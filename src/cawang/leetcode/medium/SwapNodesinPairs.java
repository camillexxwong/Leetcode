package cawang.leetcode.medium;

import cawang.leetcode.structure.ListNode;

/**
 * 
 * @author cawang
 * Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

	Hide Tags Linked List

 *
 */
public class SwapNodesinPairs {
	/**
	 * 
	 * @param head
	 * @return
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * 直观方法，遍历并交换，维护三个指针，当前指针current, 当前指针的前节点previous, 后节点next
	 * 每次交换current与next，并使previous指向next
	 */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode current=head;
        ListNode previous=null;
        ListNode newHead=head.next;
        while(current!=null){
        	ListNode next=current.next;
        	if(next==null) break;
        	current.next=next.next;
        	next.next=current;
        	if(previous!=null)previous.next=next;
        	previous=current; //before current=current.next;
        	current=current.next;
        }
        return newHead;
    }
    
    public static void main(String[] args){
    	SwapNodesinPairs obj=new SwapNodesinPairs();
    	ListNode list1=ListNode.generateList(new int[]{1,2});
    	System.out.println(list1);
    	System.out.println(obj.swapPairs(list1));
    	ListNode list2=ListNode.generateList(new int[]{1,2,3,4});
    	System.out.println(list2);
    	System.out.println(obj.swapPairs(list2));
    }
}
