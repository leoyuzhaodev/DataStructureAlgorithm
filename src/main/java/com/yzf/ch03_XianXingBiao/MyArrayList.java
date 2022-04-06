package com.yzf.ch03_XianXingBiao;

import java.util.Arrays;

public class MyArrayList<T> {
    // 定义容器长度
    private int size;

    // 定义容器
    private Object[] array;

    public MyArrayList() {
        this.size = 0;
        this.array = new Object[10];
    }

    /**
     * 返回容器大小
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 添加元素
     *
     * @param t
     */
    public void add(T t) {
        // 数组扩容
        if (this.size >= this.array.length) {
            this.expand();
        }
        // 将元素添加到容器最后
        this.array[this.size] = t;
        this.size++;
    }

    /**
     * 指定索引添加元素
     *
     * @param t     元素
     * @param index 索引
     */
    public void add(T t, int index) {

        if (index < 0) {
            throw new RuntimeException("指定的index不能小于0");
        }

        // 扩容
        if (this.size >= this.array.length) {
            expand();
        }

        // 添加元素
        if (index >= this.size) {
            this.array[this.size] = t;
        } else {
            // 空出位置
            for (int i = this.size - 1; i <= index; i--) {
                this.array[i + 1] = this.array[i];
            }
            // 插入元素
            this.array[index] = t;
        }

        this.size++;
    }

    /**
     * 获取元素
     *
     * @param index 需获取元素的索引
     * @return 索引处元素
     */
    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new RuntimeException("index的取值有误，index [0,size-1]");
        }
        return (T) this.array[index];
    }

    /**
     * 删除元素
     */
    public void delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new RuntimeException("index的取值有误，index [0,size-1]");
        }
        // 移动元素
        for (int i = index; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        // 清除最后一个元素
        this.array[this.size - 1] = null;
        this.size--;
    }

    /**
     * 数组扩容
     */
    private void expand() {
        Object[] newArray = new Object[this.size * 2];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    /**
     * 展示数组
     */
    public void show() {
        if (size <= 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < this.size; i++) {
                System.out.print(this.array[i]);
                if (i < this.size - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }
    }

}
