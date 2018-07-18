package com.company.List;

import com.company.Stack_Queue.Stack;

public class LinkedListStack<E> implements Stack<E> {


    private LinkList<E> list;

    public LinkedListStack()
    {
        list=new LinkList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addfirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[]args){
        LinkedListStack<Integer> stack=new LinkedListStack<>();
        for (int i=0;i<5;i++)
        {
            stack.push(i);
        }
        stack.pop();
        System.out.println(stack);

    }
}
