package com.leetcode.num347;

import com.company.MaxHeap.PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
* 使用自定义优先队列实现题目
* */
public class Solution {

    private class Freq implements Comparable<Freq>{
        int e,freq;

        public Freq(int e, int freq)
        {
            this.e=e;
            this.freq=freq;
        }
        @Override
        public int compareTo(Freq another ) {
            if(this.freq<another.freq)
            {
                return 1;
            }
            else if(this.freq>another.freq)
            {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int num:nums)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num+1));
            }else
            {
                map.put(num,1);
            }
        }
        PriorityQueue<Freq> priorityQueue=new PriorityQueue<>();
        for(int m:map.keySet())
        {
            if(priorityQueue.getSize()<=k)
            {
                priorityQueue.enqueue(new Freq(m,map.get(m)));
            }
            else
            {
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(m,map.get(m)));
            }
        }
        List<Integer> list=new ArrayList<>();
        while (priorityQueue.isEmpty())
        {
            list.add(priorityQueue.dequeue().e);
        }
        return list;
    }
}
