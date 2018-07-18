package com.leetcode.num237;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {

    public void deleteNode(ListNode node) {
        if (node==null)
        {
            return;
        }
        if(node.next==null)
        {
            node=null;
        }
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
