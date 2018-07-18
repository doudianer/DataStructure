package com.company.Stack_Queue;

public interface Stack<E> {
    int getSize();//查看栈的大小
    boolean isEmpty();//栈是否为空
    void push(E e);//压入一个元素
    E pop();//弹出一个元素
    E peek();//查看栈顶元素


}
