package com.company.Stack_Queue;

import com.company.MyArray.Array;

/*
* 2018.5.6
* 栈
*
* */
public class ArrayStack<E> implements Stack<E> {
   Array<E> array;
   public ArrayStack(int capacty)
   {
       array=new Array<>(capacty);

   }
   public ArrayStack()
   {
       array=new Array<>();
   }

   public int getcapacity()
   {
       return getcapacity();

   }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    @Override
    public void push(E e) {
        array.addlast(e);
    }

    @Override
    public E pop() {
        return array.removelast();
    }

    @Override
    public E peek() {
        return array.getlast();
    }
    @Override
    public String toString()
    {
        StringBuilder res=new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i=0;i<array.getSize();i++)
        {
            res.append(array.get(i));
            if(i!=array.getSize()-1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
