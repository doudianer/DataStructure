package com.company.Set;

import com.company.List.LinkList;

/*
* 基于链表的Set实现
* */

public class LinkListSet<E> implements Set<E>{
    private LinkList<E> list;
    public LinkListSet()
    {
        list=new LinkList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contain(e))
        {
            list.addfirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contain(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
