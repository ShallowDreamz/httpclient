package com.TYServer.test.stringTest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringTest {
    //某个数字未出现
    @Test
    public void getNumber(){
        int arr[] = {4,2,1,6,5};
        int newArr[] = new int[6];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i] - 1] = arr[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
            if(newArr[i] == 0){
                System.out.println(i + 1);
            }
        }
    }
    //统计每个字符出现的个数
    @Test
    public void charNumberCount(){
        String s = "abcdabccddaabcd";
        char c[] = s.toCharArray();
        Map <Character,Integer>map = new HashMap();
        for (int i = 0; i < c.length; i++) {
            if(!map.containsKey(c[i])){
                map.put(c[i],1);
            }else {
                map.put(c[i],map.get(c[i]) + 1);
            }
        }
        map.put('x', 1);
        map.put('x', 2);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    //输出一个字符串里面的的数字
    @Test
    public void number(){
        String s = "eqw3da5da6cz7hf9";
        StringBuffer stringBuffer = new StringBuffer();
        char []chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 48&& chars[i] <= 57){
                stringBuffer.append(chars[i]);
            }
        }
        System.out.println(stringBuffer.toString());
    }
    //字符串去重
    @Test
    public void stringCode(){
        String s = "abcdabcddefg";
        List list = new ArrayList();
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(!list.contains(c[i])){
                list.add(c[i]);
            }
        }
        System.out.println(list.toString());
    }
    @Test
    public void stringCode01(){
        String s = "abcdabcddefg";
        char[] chars = s.toCharArray();
        /*for (int i = 0; i < ; i++) {

        }*/
    }
}
