package com.leetcode.num203;

public class Solutiondigui {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
        {
            return null;
        }
        head.next=removeElements(head.next,val);
        if(head.val==val)
        {
            return head.next;
        }else
            {
            return head;
        }
    }
    public static void main(String[]args)
    {
        int []num={1,2,6,3,4,5,6};
        ListNode head=new ListNode(num);
        System.out.println(head);
        ListNode newhead =(new Solutiondigui()).removeElements(head,6);
        System.out.println(newhead);
    }
}
