package cawang.leetcode.easy;


public class RemoveDuplicatesFromSortedList {
	/**
	 * Definition for singly-linked list.
	 * */
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return head;
        ListNode temp=head;
        while(temp!=null&&temp.next!=null){
            if(temp.val==temp.next.val) {
            	temp.next=temp.next.next;
            }
            else temp=temp.next; //notice: must add else! if temp.val==temp.next.val, don't move temp to next
        }
        return head;
    }
}
