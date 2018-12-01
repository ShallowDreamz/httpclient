package com.TYServer.util.httpAsyncClientUtils;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class TestAsyncClient implements Runnable{
    public static void main(String[] args)  {
        String url = "http://localhost:8081/selectAllJson.do";
        String body = "{\"id\" :\"2\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"\",\"address\" : \"天山\",\"birthday\" : \"\"}";
        JSONObject object = JSONObject.parseObject(body);
        try {
            AsyncServer.getResponseData(url, object);
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
    public void asyncPost(){
        String url = "http://localhost:8081/selectAllJson.do";
        String body = "{\"id\" :\"2\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"\",\"address\" : \"天山\",\"birthday\" : \"\"}";
        JSONObject object = JSONObject.parseObject(body);
        try {
            String data = AsyncServer.getResponseData(url, object);
            System.out.println("==============" + data);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String url = "http://localhost:8080/selectAllJson.do";
        String body = "{\"id\" :\"5\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"\",\"address\" : \"天山\",\"birthday\" : \"\"}";
        JSONObject object = JSONObject.parseObject(body);
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        try {
            AsyncServer.getResponseData(url, object);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
