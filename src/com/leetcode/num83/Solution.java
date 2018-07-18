package com.leetcode.num83;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {
    public ListNode createLinklist(int []arr,int n)
    {
        if(n==0)
        {
            return null;
        }
        ListNode head=new ListNode(arr[0]);
        ListNode curNode=head;

        for (int i=1;i<n;i++)
        {
            curNode.next=new ListNode(arr[i]);
            curNode=curNode.next;
        }
        return head;
    }
    public void printNode(ListNode head)
    {
        ListNode curNode=head;
        while (curNode!=null)
        {
            System.out.print(curNode.val+"-> ");
            curNode=curNode.next;
        }
        System.out.println("NULL");
    }
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null)
        {
            return null;
        }
        ListNode curNode=head;
        while (curNode.next!=null)
        {
            if (curNode.val==curNode.next.val)
            {
                curNode.next=curNode.next.next;
            }else {
                curNode=curNode.next;
            }
        }
        return head;
    }
    public static void main(String[]args)
    {
        Solution solution=new Solution();
        int []arr={1,1,2,3,3,4};
        ListNode head=solution.createLinklist(arr,6);
        solution.printNode(solution.deleteDuplicates(head));
    }
}
