package com.TYServer.test;

import com.TYServer.util.URLConnectionUtils.URLConnectionUtil;
import com.TYServer.util.httpclientUtils.HttpClientDriver;
import com.TYServer.util.httpclientUtils.HttpClientDriverChange;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParamTest {
    @Test
    public void test(){
        String url = "http://localhost:8080/getResponseBody";
        String body = "{\"url\" :\"http://localhost:8081/getResponseBody\"}";
        JSONObject jsonObject = JSONObject.parseObject(body);
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("=====" + list);
    }
    @Test
    public void test1(){
        String url = "http://192.168.2.41:8081/param_string/getResponseBody";
        String body = "{\"url\" :\"http://192.168.2.41:8080/httpclient_server/getResponseBody\"}";
        JSONObject jsonObject = JSONObject.parseObject(body);
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("=====" + list);
    }
    @Test
    public void test2(){
        String url = "http://localhost:8080/getResponseBodyUrl";
        String body = "{\"url\" :\"http://localhost:8081/getResponseBody\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        List list;
        list = URLConnectionUtil.getResponseCodeAndResponseData(url,body);
        System.out.println("=====" + list);
    }
    @Test
    public void test3(){
        String url = "http://localhost:8081/getAllSchool";
        String body = "{\"id\" :\"2\",\"name\" : \"\",\"age\":\"\",\"address\" : \"\",\"weapons\" : \"\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("=====" + list);
    }
    @Test
    public void linkedUtil(){
        String url = "http://localhost:8083/get/param/action/returnString?id=123456";
        HashMap map = new HashMap();
        map.put("token","abcd");
        map.put("Content-Type","application/json");
        String result = HttpClientDriver.httpGet(url,map);
        System.out.println("=====" + result);
    }
}
