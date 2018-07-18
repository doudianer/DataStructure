package com.leetcode.num206;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pnode=head;

        ListNode pro=null;

        while (pnode!=null)
        {
               ListNode Next=pnode.next;
                pnode.next=pro;
                pro=pnode;
                pnode=Next;

        }
        return pro;

    }


}
