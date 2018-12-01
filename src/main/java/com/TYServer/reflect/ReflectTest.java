package com.TYServer.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectTest {
    public static void main(String[] args) {
        /*Demo demo = new Demo();
        Object[] argsArr = {"hello", 1};
        methodReflect(demo, "print", argsArr);*/
        Object[] argsArr = {"hello", 1};
        methodReflect("com.TYServer.reflect.Demo", "print", argsArr);
    }

    public static void methodReflect(Object obj, String methodName, Object[] args) {

        Class[] argsClass = new Class[args.length];

        for(int i=0; i<args.length; i++) {
            argsClass[i] = args[i].getClass(); //获得每一个参数的实际类型
        }

        try {

            Method methodReflect = obj.getClass().getMethod(methodName, argsClass);//反射获得方法
            methodReflect.invoke(obj, args);    //调用此方法
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void methodReflect(String className, String methodName, Object[] args) {

        Class[] argsClass = new Class[args.length];

        for(int i=0; i<args.length; i++) {
            argsClass[i] = args[i].getClass();  //获得每一个参数的实际类型
            System.out.println(args[i].getClass());
            System.out.println(argsClass[i]);
        }

        try {

            Class c = Class.forName(className); //通过类名获得Class
            Object obj = c.newInstance();   //实例化类
            Method methodReflect = obj.getClass().getMethod(methodName, argsClass); //反射获得方法
            methodReflect.invoke(obj, args);    //调用此方法

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
