package com.TYServer.util.httpAsyncClientForApache;

import com.TYServer.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static com.TYServer.util.httpAsyncClientForApache.HttpAsyncClientUtil.createIgnoreVerifySSL;

public class AsyncServer {
    public static String[] send(String url, Map map, HashMap<String, String> header,final String encoding)
            throws KeyManagementException, NoSuchAlgorithmException, ClientProtocolException, IOException {
        final ExceptionHandlerImpl handler = new ExceptionHandlerImpl();
        StringEntity entity;
        //绕过证书验证，处理https请求
        SSLContext sslcontext = createIgnoreVerifySSL();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 设置协议http和https对应的处理socket链接工厂的对象
        Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder.<SchemeIOSessionStrategy>create()
                .register("http", NoopIOSessionStrategy.INSTANCE)
                .register("https", new SSLIOSessionStrategy(sslcontext))
                .build();
        //配置io线程
        IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setIoThreadCount(Runtime.getRuntime().availableProcessors()).build();
        //设置连接池大小
        ConnectingIOReactor ioReactor;
        ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
        PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(ioReactor, null, sessionStrategyRegistry, null);
        //创建自定义的httpclient对象
        final CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        if (!header.isEmpty() || null != header) {
            Set<?> entrySet = header.entrySet();
            for (Iterator<?> itor = entrySet.iterator(); itor.hasNext();) {
                Map.Entry<?, ?> entry = (Map.Entry<?, ?>) itor.next();
                httpPost.addHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        String jsonBody = JsonUtil.MapToJson(map);
        entity = new StringEntity(jsonBody,"utf-8");
        //设置参数到请求对象中
        httpPost.setEntity(entity);
        // Start the client
        client.start();
        //执行请求操作，并拿到结果（异步）
        final String[] result = {""};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        client.execute(httpPost, new FutureCallback<HttpResponse>() {
            @Override
            public void failed(Exception ex) {
                handler.failed(ex);
                HttpAsyncClientUtil.close(client);
            }
            @Override
            public void completed(HttpResponse resp) {
                String body="";
                //这里使用EntityUtils.toString()方式时会大概率报错，原因：未接受完毕，链接已关
                try {
                    HttpEntity entity = resp.getEntity();
                    if (entity != null) {
                        final InputStream instream = entity.getContent();
                        try {
                            final StringBuilder sb = new StringBuilder();
                            final char[] tmp = new char[1024];
                            final Reader reader = new InputStreamReader(instream,encoding);
                            int l;
                            while ((l = reader.read(tmp)) != -1) {
                                sb.append(tmp, 0, l);
                            }
                            body = sb.toString();
                            result[0] = body;
                            countDownLatch.countDown();
                        } finally {
                            instream.close();
                            EntityUtils.consume(entity);
                        }
                    }
                } catch (ParseException | IOException e) {
                    e.printStackTrace();
                }
                handler.completed(body);
                HttpAsyncClientUtil.close(client);
            }

            @Override
            public void cancelled() {
                handler.cancelled();
                HttpAsyncClientUtil.close(client);
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
