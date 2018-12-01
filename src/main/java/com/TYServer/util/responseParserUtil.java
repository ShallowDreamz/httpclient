package com.TYServer.util;

import com.alibaba.fastjson.JSONObject;

public class responseParserUtil {
    public static String getToken(String loginResponse){
        JSONObject json = JSONObject.parseObject(loginResponse);
        String data = json.get("data").toString();
        JSONObject tokenJson = JSONObject.parseObject(data);
        String token = tokenJson.get("token").toString();
        return token;
    }
}
