package com.TYServer.test.httpAsyncClientTest;

import com.TYServer.util.httpAsyncClientForApache.AsyncServer;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
//selectResultByUrlBodyUseAsyncForApache
public class HttpAsyncClientForApacheTest {
    @Test
    public void test(){
        String string[] = null;
        String url = "http://localhost:8080/selectResultByUrlBodyUseAsyncForApache.do";
        String body = "{\"url\":\"http://localhost:8081/selectEmployee.do?pageIndex=1\",\"body\":{\"encode\":\"utf-8\",\"Object\":\"object\",\"birthday\":null,\"employee\":{\"address\":\"\",\"name\":\"\",\"id\":1,\"age\":\"\",\"birthday\":null,\"sex\":\"\"}}}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        try {
            string = AsyncServer.send(url,jsonObject,map,"utf-8");
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(string[0]);
    }
}
