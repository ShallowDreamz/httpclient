package com.TYServer.test.asyncClientTest;

import com.TYServer.util.httpAsyncClientUtils.AsyncServer;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class AsyncClientTest {
    @Test
    public void selectRestInterface(){
        String url = "http://localhost:8080/selectResultByUrlBodyUseAsync.do";
        String body = "{\"url\":\"http://localhost:8081/selectEmployee.do?pageIndex=1\",\"path\":\"E:\\\\selectBody.txt\"}";
        JSONObject jsonObject = JSONObject.parseObject(body);
        try {
            String data = AsyncServer.getResponseData(url,jsonObject);
            int status = AsyncServer.getStatusCode(url,jsonObject);
            System.out.println(status + "=====" + data);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertRestInterface(){
        String url = "http://localhost:8081/selectResultByUrlBodyUseAsync.do";
        String body = "{\"url\":\"http://localhost:8080/insertEmployee.do?birthday=2011-11-02\",\"path\":\"E:\\\\insertBody.txt\"}";
        JSONObject jsonObject = JSONObject.parseObject(body);
        try {
            String data = AsyncServer.getResponseData(url,jsonObject);
            //int status = AsyncServer.getStatusCode(url,jsonObject);
            System.out.println( "=====" + data);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getTypeForRestInterFace(){
        String url = "http://localhost:8080/getTypeToTYServer.do";
        String body = "{\"url\":\"http://localhost:8081/returnString.do\",\"path\":\"\"}";
        JSONObject jsonObject = JSONObject.parseObject(body);
        try {
            String data = AsyncServer.getResponseData(url,jsonObject);
            int status = AsyncServer.getStatusCode(url,jsonObject);
            System.out.println(status + "=====" + data);
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
