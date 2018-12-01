package com.TYServer.test;

import com.TYServer.util.httpclientUtils.HttpClientDriverChange;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Param implements Runnable{
    @Test
    public void multiply(){
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(j  + " * " +  i  + " = " +  j * i + "   ");
            }
            System.out.println();
        }
    }
    @Test
    public void multiply01(){
        for(int i = 9;i >= 1;i--){
            for(int j = i;j <= 9&&j >= 1;j--){
                System.out.print(j  + " * " +  i  + " = " +  j * i + "   ");
            }
            System.out.println();
        }
    }
    @Test
    public void test(){
        int sum = 0;
        for (int i = 1;i <= 100;i++){
            sum = sum + i;
        }
        System.out.println(sum);
    }
    @Test
    public void aVoid() {
        for (int i = 1; i < 50001; i++) {
            String url = "http://10.128.1.13:8080/agent/addMEM";
            HashMap map = new HashMap();
            HttpClientDriverChange.httpGet(url,map);
            if(i % 1000 == 0){
                aoid();
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void aoid() {
        String url = "http://10.128.1.13:8080/agent/clearMEM";
        HashMap map = new HashMap();
        HttpClientDriverChange.httpGet(url,map);
    }


    @Test
    public void memAdd() {
        for (int i = 1; i < 10000; i++) {
            String url = "http://10.128.1.13:8080/ParamTest/mem";
            HashMap map = new HashMap();
            HttpClientDriverChange.httpGet(url,map);
            if(i % 1000 == 0){
                memClean();
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void memClean() {
        String url = "http://10.128.1.13:8080/ParamTest/memclean";
        HashMap map = new HashMap();
        HttpClientDriverChange.httpGet(url,map);
    }

    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            Param param = new Param();
            Thread thread = new Thread(param);
            thread.setName("ab" + System.currentTimeMillis());
            thread.start();
        }
    }
    @Override
    public void run() {
        while (true){
            String url = "http://10.128.1.13:8080/ParamTest/getParams?id=123456";
            HashMap map = new HashMap();
            HttpClientDriverChange.httpGet(url,map);
        }
    }
    @Test
    public void s(){
        String s = "";
        for (int i = 0; i < 5; i++) {
            s = "a" + s;
            System.out.println(s);
        }
        System.out.println(Integer.parseInt("1"));
    }
    @Test
    public void SB(){
        String s = "aa1bb2gogoh5";
        String s1 = "";
        String regexNum = "\\d+";
        String regex = "\\D+";
        String[] arr = s.split(regexNum);
        String[] arrNum = s.split(regex);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < arrNum.length; i++) {
            if(arrNum[i] != null && arrNum[i].length() > 0){
                list.add(Integer.parseInt(arrNum[i].trim()));
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < list.size(); j++) {
                System.out.print(list.get(j) + "  ");
                for (int k = 0; k < list.get(j); k++) {
                    s1 = s1 + arr[i];
                }
                break;
            }
        }
        System.out.println(s1);

    }
}
