package com.company;

import com.company.List.LinkList;
import com.company.Stack_Queue.Queue;

import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> q, int opCount)
    {

        long start=System.nanoTime();
        Random random=new Random();
        for(int i=0;i<opCount;i++)
        {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++)
        {
            q.dequeue();

        }
        long end=System.nanoTime();
        return (end-start)/1000000000.0;
    }

    public static void main(String[] args) {
	// write your code here
        /*Array<Integer> arr=new Array<Integer>();
        for(int i=0;i<90;i++)
        {
        arr.addlast(i);
        }
        arr.add(1,100);

        System.out.println(arr);*/

        /*ArrayStack<Integer> stack=new ArrayStack<>();
        for(int i=0;i<10;i++)
        {
            stack.push(i);
        }
        System.out.println(stack);
    */

       /* int opCount=100000;
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        double time1=testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

*/
       LinkList<Integer> linkList=new LinkList<>();
       for (int i=0;i<5;i++)
       {
           linkList.addfirst(i);
           System.out.println(linkList);
       }
       linkList.add(6,1);
       System.out.println(linkList);
       linkList.remove(1);
       System.out.println(linkList);
       System.out.println(linkList.hashCode());

    }

}
