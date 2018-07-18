package com.leetcode.num82;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {


    public ListNode deleteDuplicates(ListNode head) {

        ListNode dmhead=new ListNode(-1);
        dmhead.next=head;

        ListNode pre=dmhead;
        while (head!=null)
        {
            if(head.next!=null&&head.val==head.next.val)
            {
                int value=head.val;
                while (head!=null&&head.val==value)
                {
                    pre.next=head.next;
                    head=head.next;
                }
            }else {
                pre=head;
                head=head.next;
            }

        }
        return  dmhead.next;
    }
}
