package com.TYServer.test;

import com.TYServer.util.httpclientUtils.HttpClientDriverChange;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

public class test {
    public static void main(String args[]){
       /* Scanner scanner = new Scanner(System.in);
        System.out.print("请输入计算的天数：");
        int day = scanner.nextInt();
        int sum = 0;
        int a;
        for(a = 1;a <= day;a++) {
            day = day - a;
            sum =sum + a * a;
        }
        sum = sum + a * day;
        System.out.println("一共获得的金币是"+sum);*/
       /* try {
            while (true){
                System.out.println(readFS(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
       String s = getString("E:\\abc.txt");
       String [] strings = s.split(",");
       for (int i = 0;i <= strings.length - 1;i++){
           System.out.println("这是第" + (i + 1) + "个用户登录,登录名是：" + strings[i]);
           for(int j = 0;j < 400;j++){
               strings[i].toString();
           }
       }
    }
    public static String transMapToString(Map map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
            entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append( "'" ).append(null==entry.getValue()?"":
                    entry.getValue().toString()).append (iterator.hasNext() ? "^" : "");
        }
        return sb.toString();
    }

    public static  String readFS(int number) throws IOException {
        int lineNo=0;
        String a;
        FileReader fr;
        List<String> list = new ArrayList<>();
        try {
            fr = new FileReader("E:\\abc.txt");//读取用户名文件
            list =new ArrayList();
            BufferedReader br=new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null) {
                if(lineNo==number){
                    a=line;
                    list.add(a);
                }
                number++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for(int z=0;z<list.size();z++){
            list.get(z);
        }
        return list.get(number);
    }
    public static String getString(String path){
        StringBuffer sb = new StringBuffer();
        String encode = "utf-8";
        FileInputStream fis = null;
        InputStreamReader read = null;
        BufferedReader br;
        try {
            fis = new FileInputStream(path);
            read = new InputStreamReader(fis,encode);
            br = new BufferedReader(read);
            String textLine;
            while((textLine = br.readLine()) != null){
                sb.append(textLine + ",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
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
    public void test01(){
        int i[] = {2,4,3,7,6,8};
        int temp;
        for (int j = 0; j < i.length; j++) {
            for (int k = j + 1; k < i.length; k++) {
                if(i[j] > i[k]){
                    temp = i[j];
                    i[j] = i[k];
                    i[k] = temp;
                }
            }
        }
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }
    @Test
    public void test02(){
        String s = "fabac";
        //StringBuffer sb = new StringBuffer();
        String sb;
        List list = new ArrayList();
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb = c[i] + "";
            for (int j = i + 1; j < c.length; j++) {
                sb = sb + c[j];
                list.add(sb);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "    ");
        }
    }
    @Test
    public void test03(){
        String s = "{\"uuid\":\"E36356DF-1AB2-41FA-8A97-A6F9E2CD660B\",\"roleId\":1,\"roleKey\":\"super_admin\",\"expired\":1539924567358}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        String expired = jsonObject.getString("expired");
        System.out.println(expired);
    }
    @Test
    public static void getIPAddress(){
        Enumeration<NetworkInterface> allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ipHost = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ipHost = addresses.nextElement();
                    if (ipHost != null && ipHost instanceof Inet4Address) {
                        System.out.println("本机的HOSTiP = " + ipHost.getHostAddress());
                        System.out.println("本机的HOSTNAME = " + ipHost.getHostName());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSearch(){
        int arr[] = {1,2,3,4,4,4,4,4,9};
        //Arrays.sort(arr);
        int i = index(arr,4);
        System.out.println(i);
    }
    public int index(int arr[],int key){
        if(key > arr[arr.length - 1]){
            return -2;
        }
        int start = 0;
        int end = arr.length;
        while (start <= end){
            int middle = (start + end) / 2;
            if(key < arr[middle]){
                end = middle - 1;
            }else if(key > arr[middle]){
                start = middle + 1;
            }else {
                while (true){
                    int temp = middle;
                    if(arr[temp - 1] == key){
                        middle = middle - 1;
                        continue;
                    }
                    return temp;
                }
            }
        }
        return -1;
    }
}