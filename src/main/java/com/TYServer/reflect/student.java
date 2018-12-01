package com.TYServer.reflect;

import java.io.Serializable;

public class student implements Serializable{
    private String name;
    private Integer age;
    public student(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge!!");
        this.age = age;
    }

    private void first(String name, Integer age){
        System.out.println("this is first method!!");
    }

    public void second(Integer age){
        System.out.println("this is second method!!");
    }
    public student(){
        System.out.println("no parameter!!!");
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
