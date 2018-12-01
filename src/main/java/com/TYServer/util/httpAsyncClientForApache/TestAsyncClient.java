package com.TYServer.util.httpAsyncClientForApache;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class TestAsyncClient implements Runnable{
    public static void main(String[] args)  {
        String url = "http://localhost:8081/selectAllJson.do";
        String body = "{\"id\" :\"5\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"\",\"address\" : \"天山\",\"birthday\" : \"\"}";
        JSONObject object = JSONObject.parseObject(body);
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        try {
           String s[] = AsyncServer.send(url, object, map,"utf-8");
            System.out.println(s[0] + "===========");
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* Runnable runnable = new TestAsyncClient();
        Thread t = new Thread(runnable);
        t.start();*/
    }
    @Test
    public void asyncPost() throws NoSuchAlgorithmException, KeyManagementException, IOException, ExecutionException, InterruptedException {
        ExceptionHandlerImpl handler = new ExceptionHandlerImpl();
        String url = "http://localhost:8081/selectAllJson.do";
        String body = "{\"id\" :\"5\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"\",\"address\" : \"天山\",\"birthday\" : \"\"}";
        JSONObject object = JSONObject.parseObject(body);
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        AsyncServer.send(url, object, map,"utf-8");
    }

    @Override
    public void run() {
        ExceptionHandlerImpl handler = new ExceptionHandlerImpl();
        String url = "http://localhost:8080/selectAllJson.do";
        String body = "{\"id\" :\"5\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"\",\"address\" : \"天山\",\"birthday\" : \"\"}";
        JSONObject object = JSONObject.parseObject(body);
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        try {
            AsyncServer.send(url, object, map,"utf-8");
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
