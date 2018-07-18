package com.leetcode.num203;
/*
* 增加虚拟头节点的删除节点操作
*
* */
public class Solution_add_head {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dhead= new ListNode(-1);
        dhead.next=head;
        ListNode prev=dhead;
        while (prev.next!=null)
        {
            if(prev.next.val==val)
            {
                prev.next=prev.next.next;
            }
            else
            {
                prev=prev.next;
            }
        }
        return dhead.next;

    }

    public static void main(String[]args)
    {
        int []num={1,2,6,3,4,5,6};
        ListNode head=new ListNode(num);
        System.out.println(head);
        ListNode newhead =(new Solution_add_head()).removeElements(head,6);
        System.out.println(newhead);
    }
}
