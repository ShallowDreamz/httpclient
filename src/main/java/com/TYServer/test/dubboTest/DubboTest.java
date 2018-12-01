package com.TYServer.test.dubboTest;

import com.TYServer.util.httpclientUtils.HttpClientDriverChange;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class DubboTest {
    @Test
    public void getListAll(){
        String url = "http://localhost:8081/getEmployeeUsedubbo.do";
        String body = "{\"id\" :\"1\" ,\"name\" : \"\",\"sex\" : \"\",\"age\":\"\",\"address\" : \"\",\"birthday\" : \"\"}";
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
}
