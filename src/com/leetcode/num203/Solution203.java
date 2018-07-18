package com.leetcode.num203;

/*
* leetcode 203题
* 2018年5月10日
* */

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val==val)
        {
            head=head.next;
        }
        if(head==null)
        {
            return null;
        }

        ListNode prev=head;
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
        return head;

    }


}
