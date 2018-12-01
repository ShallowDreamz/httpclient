package com.TYServer.test.linkedTest;

import org.testng.annotations.Test;

public class LinkedListTest {
    private int size;
    private Node header;
    public LinkedListTest(){
        size = 0;
        header = null;
    }
    public class Node{
        private Object object;
        private Node next;

        public Node(Object object) {
            this.object = object;
        }
    }
    //添加元素
    public Object insertNode(Object object){
        Node node = new Node(object);
        if(size == 0){
            header = node;
        }else {
            node.next = header;
            header = node;
        }
        size++;
        return object;
    }

    @Test
    public void insertNodeTest(){
        LinkedListTest linkedListTest = new LinkedListTest();
        System.out.println(linkedListTest.insertNode("a"));
    }
}
