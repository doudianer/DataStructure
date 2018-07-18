package com.leetcode.num92;

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

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode l = null;
        ListNode r=null;
        int count=0;
        while (head!=null)
        {

            if(count==m-1)
            {
                l=head;
            }
            if(count==n+1)
            {
                r=head;
            }

            head=head.next;
        }
        ListNode pro=r;
        ListNode pnode=l.next;
        while (pnode!=r)
        {
            ListNode Next=pnode.next;
            pnode.next=pro;
            pro=pnode;
            pnode=Next;
        }
        return head;
    }


    public static void main(String[]args)
    {
        Solution solution=new Solution();
        int []arr={1,2,3,4,5};
       ListNode head= solution.createLinklist(arr,5);
        solution.printNode(head);

    }

}
