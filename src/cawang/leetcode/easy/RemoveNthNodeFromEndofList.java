package cawang.leetcode.easy;

import cawang.leetcode.structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveNthNodeFromEndofList {
    //Given n will always be valid.
    //2 mistake: check if(end==null); removing head logic - return head.next;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        ListNode target=head;
        ListNode end=head;
        for(int i=1;i<=n;i++){
            end=end.next;
        }
        if(end==null) {//removing head
            //return null; {1,2}, 2 - > {2}, not {}
            return head.next;
        }
        while(end.next!=null){
            end=end.next;
            target=target.next;
        }
        if(target.next!=null){
            //t=target.next;
            target.next=target.next.next;
        }
        return head;
    }
}
