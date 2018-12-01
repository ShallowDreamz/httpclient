package com.TYServer.util.URLConnectionUtils;

import com.alibaba.fastjson.JSONObject;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLConnectionUtil {
    public static List getResponseCodeAndResponseData(String TYServerUrl,String Body){
       try {
           List list = new ArrayList();
           String responseData;
           URL url = new URL(TYServerUrl);
           HttpURLConnection httpURLConnection;
           JSONObject jsonObject = JSONObject.parseObject(Body);
           httpURLConnection = (HttpURLConnection) url.openConnection();
           httpURLConnection.setDoInput(true);
           httpURLConnection.setDoOutput(true);
           httpURLConnection.setRequestMethod("POST");
           httpURLConnection.setUseCaches(false);
           httpURLConnection.setRequestProperty("Content-Type","application/octet-stream");
           OutputStream buf = httpURLConnection.getOutputStream();
           DataOutputStream out = new DataOutputStream(buf);
           out.write(jsonObject.toString().getBytes());
           int responseCode = httpURLConnection.getResponseCode();
           out.flush();
           out.close();
           InputStream inStream = httpURLConnection.getInputStream();
           BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
           StringBuffer buffer = new StringBuffer();
           String line ;
           while ((line = in.readLine()) != null){
               buffer.append(line);
           }
           responseData = buffer.toString();
           list.add(responseCode);
           list.add(responseData);
           return list;
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;
   }
}
