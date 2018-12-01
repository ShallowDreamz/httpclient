package com.TYServer.reflect;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectMethod {
    @Test
    public void test(){
        try {
            Class cl = Class.forName("com.TYServer.reflect.student");
            Method method[] = cl.getMethods();
            for (int i = 0; i < method.length; i++) {
                System.out.println(method[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test01(){
        try {
            Class cl = Class.forName("com.TYServer.reflect.student");
            Method method[] = cl.getDeclaredMethods();
            for (int i = 0; i < method.length; i++) {
                System.out.print(Modifier.toString(method[i].getModifiers()) + "  ");//取得修饰符
                System.out.print(method[i].getReturnType().getSimpleName() + "  ");//获得返回类型
                System.out.print(method[i].getName());//取得方法名
                Class<?>[] params = method[i].getParameterTypes();
                if(params.length > 0){
                    for (int j = 0; j < params.length; j++) {
                        System.out.print(" " + params[j] + " ");//获取方法的所有参数
                    }
                }
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test03(){
        try {
            Class cl = Class.forName("com.TYServer.reflect.student");
            Object object = cl.newInstance();
            Object[] argsArr = {"hello", 1};
            Class clazz[] = new Class[argsArr.length];
            for (int j = 0; j < argsArr.length; j++) {
                clazz[j] = argsArr[j].getClass();
                System.out.println(clazz[j]);
            }
            Method method = cl.getDeclaredMethod("first",clazz);
            method.setAccessible(true);
            method.invoke(object,argsArr);
            /*Method method[] = cl.getDeclaredMethods();
            for (int i = 0; i < method.length; i++) {
                if(method[i].getName().equals("first")){
                    method[i].setAccessible(true);
                    Object[] argsArr = {"hello", 1};
                    method[i].invoke(object,argsArr);
                }
            }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test04(){
        try {
            Class cl = Class.forName("com.TYServer.reflect.student");
            Object object = cl.newInstance();
            Field field[] = cl.getDeclaredFields();
            for (int i = 0; i < field.length; i++) {
                System.out.println(field[i]);
                field[i].setAccessible(true);
                System.out.println(field[i].getName() + "===" + field[i].getType());
                if(field[i].getType().toString().endsWith("String")){
                    Method method = cl.getDeclaredMethod("get" + field[i].getName().substring(0, 1).toUpperCase() + field[i].getName().substring(1));
                    Integer value = (Integer) method.invoke(object);
                    if(value == null){
                        method = cl.getDeclaredMethod("set" + field[i].getName().substring(0, 1).toUpperCase() + field[i].getName().substring(1),String.class);
                        method.invoke(object,"zhanghuibin");
                    }
                }else if(field[i].getType().toString().endsWith("int") || field[i].getType().toString().endsWith("Integer")){
                    field[i].set(object,18);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
