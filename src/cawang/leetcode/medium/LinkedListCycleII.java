package cawang.leetcode.medium;

import cawang.leetcode.structure.ListNode;

/**
 * @author cawang
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

	Follow up:
	Can you solve it without using extra space?
	
 * @see See LinkedListCycle for reference
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        return detectCycle_1(head);
        //return detectCycle_2(head);
    }


	private ListNode detectCycle_1(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(true){
			if(fast==null||fast.next==null) return null;
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}
		fast=head;
		while(fast!=slow){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	//TLE
	private ListNode detectCycle_2(ListNode head) {
		ListNode pointer1=head;
		int step1=0;
		while(pointer1!=null){
			step1++;
			ListNode pointer2=head;
			int step2=1; //!!!! for{1}, no cycle
			while(pointer2!=pointer1){
				pointer2=pointer2.next;
				step2++;
			}
			if(step1==step2) pointer1=pointer1.next;
			else return pointer2;
		}
		return null;
	}
}
