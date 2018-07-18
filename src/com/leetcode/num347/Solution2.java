package com.leetcode.num347;

import java.util.*;
/*
*
* 使用官方优先队列
* */
public class Solution2 {
    private class Freq {//implements Comparable<Freq>{
        int e,freq;

        public Freq(int e, int freq)
        {
            this.e=e;
            this.freq=freq;
        }
        /*
        @Override
        public int compareTo(Freq another ) {
            if(this.freq<another.freq)
            {
                return -1;
            }
            else if(this.freq>another.freq)
            {
                return 1;
            }
            else {
                return 0;
            }
        }
        */
    }

    private class FreqComparator implements Comparator<Freq>{


        @Override
        public int compare(Freq o1, Freq o2) {
             return o1.freq-o2.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int num:nums)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }else
            {
                map.put(num,1);
            }
        }
        PriorityQueue<Freq> priorityQueue=new PriorityQueue<>(new FreqComparator());
        for(int m:map.keySet())
        {
            if(priorityQueue.size()<k)
            {
                priorityQueue.add(new Freq(m,map.get(m)));
            }
            else if(map.get(m)>priorityQueue.peek().freq)
            {
                priorityQueue.remove();
                priorityQueue.add(new Freq(m,map.get(m)));
            }
        }
        List<Integer> list=new ArrayList<>();
        while (!priorityQueue.isEmpty())
        {
            list.add(priorityQueue.remove().e);
        }
        return list;
    }
}
