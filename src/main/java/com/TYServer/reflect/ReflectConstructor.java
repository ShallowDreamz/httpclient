package com.TYServer.reflect;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructor {
    public static void main(String args[]) {
        int i=1;
        for(i=1;i<=10;i++){

            System.out.println(i);
        }
    }
    @Test
    public void test() {
        try {
            Class cl = Class.forName("com.TYServer.reflect.student");
            Constructor constructor = cl.getConstructor(String.class,Integer.class);
            Object object = constructor.newInstance("zhanghuibin",18);
            System.out.println(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
     @Test
    public void test01(){
         try {
             Class cl = Class.forName("com.TYServer.reflect.student");
             Object object = cl.newInstance();
             System.out.println(object);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (InstantiationException e) {
             e.printStackTrace();
         }
     }
     @Test
    public void test02(){
         try {
             Class cl = Class.forName("com.TYServer.reflect.student");
             Constructor[] constructor = cl.getConstructors();
             for (int i = 0; i < constructor.length ; i++) {
                 System.out.println(constructor[i]);
             }
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
}
