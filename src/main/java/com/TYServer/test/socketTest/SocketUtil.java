package com.TYServer.test.socketTest;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketUtil {
    public static Socket getConnection(String ip, int port) {
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
            //socket.setSoTimeout(100000);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

    public static String send(Socket socket, String cmd) {
        InputStream in = null;
        OutputStream out = null;
        BufferedReader br = null;
        try {
            //br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"GB2312"));
            long startTime = System.currentTimeMillis();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "GB2312"), true);
            printWriter.print(cmd);
            printWriter.flush();
            // 接收执行命令结果
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            long endTime = System.currentTimeMillis();
            System.out.println("发送数据时间为：" + (endTime - startTime));
            long responseStartTime = System.currentTimeMillis();
            char[] c = new char[8];
            br.read(c);
            long responseEndTime = System.currentTimeMillis();
            System.out.println("接收结果时间为：" + (responseEndTime - responseStartTime));
            return new String(c);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Socket socket = null;
        String cmd = "016361011429118923050617052518616026003000000000000您尾号2667的信用卡在我行积分商城支付操作的动态验证码为353634，五分钟内输入有效，任何人索取验证码均为诈骗，切勿泄露。";
        try {
            long startTime = System.currentTimeMillis();
            socket = SocketUtil.getConnection("192.168.0.102", 8804);
            long endTime = System.currentTimeMillis();
            System.out.println("建立连接时间为：" + (endTime - startTime));
            long sendStartTime = System.currentTimeMillis();
            String resultStr = SocketUtil.send(socket, cmd);
            long sendEndTime = System.currentTimeMillis();
            System.out.println("发送接收总时间为：" + (sendEndTime - sendStartTime));
            System.out.println(resultStr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("关闭链接！！");
        }finally {
            SocketUtil.close(socket);
        }
    }
}
