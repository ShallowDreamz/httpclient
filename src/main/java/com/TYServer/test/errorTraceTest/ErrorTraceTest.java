package com.TYServer.test.errorTraceTest;

import com.TYServer.util.httpclientUtils.HttpClientDriverChange;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class ErrorTraceTest {
    private final static Logger logger = LoggerFactory.getLogger(ErrorTraceTest.class);
    @Test
    public void errorTest(){
        String url = "http://localhost:8081/errorTrace.do";
        String body = "{\"number\" :\"1\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void error(){
        String url = "http://localhost:8080/errorTrace.do";
        String body = "{\"id\" :\"1\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void badSQL(){
        String url = "http://localhost:8080/badSQL.do";
        String body = "{\"id\" :\"1\",\"name\" : \"\",\"sex\" : \"\",\"age\":\"\",\"address\" : \"\",\"birthday\" : \"\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
    @Test
    public void fileNotFound(){
        String url = "http://localhost:8080/fileNotFoundException.do";
        String body = "{\"filePath\" :\"E:\\\\selectBody1.txt\"}";
        HashMap map = new HashMap();
        map.put("Content-Type","application/json");
        JSONObject jsonObject = JSONObject.parseObject(body);
        List list = null;
        try {
            list = HttpClientDriverChange.httpPost(url,jsonObject,map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("=====" + list);
    }
}
