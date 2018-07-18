package com.leetcode.num24;

import javax.swing.*;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dmhead=new ListNode(0);
        dmhead.next=head;
        ListNode pre=dmhead;
        while (pre.next!=null&&pre.next.next!=null)
        {
            ListNode Node1=pre.next;
            ListNode Node2=pre.next.next;
            ListNode Next=Node2.next;

            Node2.next=Node1;
            pre.next=Node2;
            Node1.next=Next;
            pre=Node1;
        }
        return dmhead.next;
    }
}
