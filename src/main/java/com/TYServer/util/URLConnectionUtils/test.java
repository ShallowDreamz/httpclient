package com.TYServer.util.URLConnectionUtils;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
   @Test
    public void urlTest(){
       try {
           String response;
           URL url = new URL("http://localhost:8081/selectAllJson.do");
           HttpURLConnection httpURLConnection;
           JSONObject jsonObject = JSONObject.parseObject("{\"id\" :\"6\" ,\"name\" : \"天山\",\"sex\" : \"无\",\"age\":\"130\",\"address\" : \"天山\",\"birthday\" : \"\"}");
           httpURLConnection = (HttpURLConnection) url.openConnection();
           httpURLConnection.setDoInput(true);
           httpURLConnection.setDoOutput(true);
           httpURLConnection.setRequestMethod("POST");
           httpURLConnection.setUseCaches(false);
           httpURLConnection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
           OutputStream buf = httpURLConnection.getOutputStream();
           DataOutputStream out = new DataOutputStream(buf);
           out.write(jsonObject.toString().getBytes());
           int responseCode = httpURLConnection.getResponseCode();
           System.out.println(responseCode);
           out.flush();
           out.close();
           InputStream inStream = httpURLConnection.getInputStream();
           /*byte[] data = new byte[in.available()];
           in.read(data);
           response = new String(data);
           System.out.println(response);*/
           BufferedReader in = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
           StringBuffer buffer = new StringBuffer();
           String line ;
           while ((line = in.readLine()) != null){
               buffer.append(line);
           }
           response = buffer.toString();
           System.out.println(response);
       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
