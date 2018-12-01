package com.TYServer.util.httpAsyncClientUtils;

import org.asynchttpclient.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncServer {
    public static String getResponseData(String url, Map map) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        String statusCode = null;
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        Future<String> f = asyncHttpClient.preparePost(url).setBody(map.toString()).setHeader("Content-Type","application/json;charset=UTF-8").execute(
                new AsyncCompletionHandler<String>(){

                    public String onCompleted(Response response) throws Exception{
                        // Do something with the Response
                        return response.getResponseBody();
                    }

                    public void onThrowable(Throwable t){
                        // Something wrong happened
                        t.printStackTrace();
                    }
                });
        try {
            statusCode = f.get();
            asyncHttpClient.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return statusCode;
    }
    public static int getStatusCode(String url, Map map) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        int statusCode = 0;
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        Future<Integer> f = asyncHttpClient.preparePost(url).setBody(map.toString()).setHeader("Content-Type","application/json").execute(
                new AsyncCompletionHandler<Integer>(){

                    public Integer onCompleted(Response response) throws Exception{
                        // Do something with the Response
                        return response.getStatusCode();
                    }

                    public void onThrowable(Throwable t){
                        // Something wrong happened.
                        t.printStackTrace();
                    }
                });
        try {
            statusCode = f.get();
            asyncHttpClient.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return statusCode;
    }
    public static String getTypeForDate(String url) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        String responseBody = null;
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        Future<String> f = asyncHttpClient.prepareGet(url).setHeader("Content-Type","application/json;charset=UTF-8").execute(
                new AsyncCompletionHandler<String>(){

                    public String onCompleted(Response response) throws Exception{
                        // Do something with the Response
                        return response.getResponseBody();
                    }

                    public void onThrowable(Throwable t){
                        // Something wrong happened
                        t.printStackTrace();
                    }
                });
        try {
            responseBody = f.get();
            asyncHttpClient.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return responseBody;
    }
    public static int getTypeForStatus(String url) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        int status = 0;
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        Future<Integer> f = asyncHttpClient.prepareGet(url).setHeader("Content-Type","application/json;charset=UTF-8").execute(
                new AsyncCompletionHandler<Integer>(){

                    public Integer onCompleted(Response response) throws Exception{
                        // Do something with the Response
                        return response.getStatusCode();
                    }

                    public void onThrowable(Throwable t){
                        // Something wrong happened
                        t.printStackTrace();
                    }
                });
        try {
            status = f.get();
            asyncHttpClient.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return status;
    }
}
