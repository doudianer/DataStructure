package com.leetcode.num86;

import com.sun.javafx.scene.control.skin.LabeledSkinBase;
import org.w3c.dom.ls.LSInput;

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

    public ListNode partition(ListNode head, int x) {
        if (head==null)
        {
            return null;
        }
        ListNode curNode=head;
        ListNode lNode=null;
        ListNode rNode=null;
        ListNode lheads=null;
        ListNode rheads=null;
        while (curNode!=null)
        {
            if(curNode.val<x)
            {
                if(lheads==null)
                {
                    lNode=new ListNode(curNode.val);
                    lheads=lNode;
                }else {
                    lNode.next=new ListNode(curNode.val);
                    lNode=lNode.next;
                }
            }
            if(curNode.val>=x)
            {
                if(rheads==null)
                {
                    rNode=new ListNode(curNode.val);
                    rheads=rNode;
                }else {
                    rNode.next=new ListNode(curNode.val);
                    rNode=rNode.next;
                }
            }
            curNode=curNode.next;
        }
        if(lheads==null)
        {
            return rheads;
        }else {
            lNode.next=rheads;
            return lheads;
        }
    }
    public static void main(String[]args)
    {
        Solution solution=new Solution();
        int []arr={1,4,3,2,5,2};
       ListNode head= solution.createLinklist(arr,6);
       solution.printNode( solution.partition(head,3));

    }

}
