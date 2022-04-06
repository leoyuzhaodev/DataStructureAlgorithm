package com.yzf.ch03_XianXingBiao;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList();
        for (int i = 0; i < 25; i++) {
            myArrayList.add(i);
        }
        myArrayList.show();
        myArrayList.delete(1);
        myArrayList.show();
        System.out.println(myArrayList.size());
        myArrayList.add(25);
        myArrayList.show();
        for (int i = 0; i < 20; i++) {
            myArrayList.delete(5);
        }
        myArrayList.show();
        System.out.println(myArrayList.size());
    }
}
