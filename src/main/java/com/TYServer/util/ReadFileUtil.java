package com.TYServer.util;

import java.io.*;

public class ReadFileUtil {
    public static String getString(String path){
        StringBuffer sb = new StringBuffer();
        String encode = "utf-8";
        FileInputStream fis;
        InputStreamReader read;
        BufferedReader br;
        try {
            fis = new FileInputStream(path);
            read = new InputStreamReader(fis,encode);
            br = new BufferedReader(read);
            String textLine;
            while((textLine = br.readLine()) != null){
                sb.append(textLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
