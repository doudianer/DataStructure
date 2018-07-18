package com.leetcode.num19;




class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dmhead=new ListNode(0);
        dmhead.next=head;
        ListNode p=dmhead;
        ListNode q=dmhead;
        for(int i=0;i<n+1;i++)
        {
            q=q.next;
        }
        while (q!=null)
        {
            q=q.next;
            p=p.next;
        }
        p.next=p.next.next;
        return dmhead.next;
    }

}
