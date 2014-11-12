package cawang.leetcode.medium;

import cawang.leetcode.structure.ListNode;


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 
 * @author CAWANG
 * 判断链表是否有环
 * Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        return hasCycle_1_slowFastPointers(head);
       // return hasCycle_2_twoPointers(head);
    }
	
	/**
	 * @param head
	 * @return
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * 原理：使用快慢指针slow和fast，两个指针同时从头开始一直向前走，slow每次走一步，fast每次走两步（也可以走n步）
	 * 当fast走到或即将走到null时，说明链表无环
	 * 如果有环，两个指针必将相遇；
	 * 未知数：n,m,t,s；已知数：x
	 * 设链表总长n, 环长m, 相遇时slow走了x步，相遇点距离环的入口点距离为t, 则头结点距离环入口为s=n-m, fast走了2x步, 
	 * 相遇时有 (2x-(n-m))- (x-(n-m))=A*m (A为任意整数，实际表示第A次相遇）， 即x=A*m;
	 * 每次的相遇点都将是同一点
	 * 
	 * 环长算法1：第一次相遇时A=1， 有x=m; 即第一次相遇时slow走过的长度刚好为环长， 由于m<n可知slow还未走完一圈
	 * 环长算法2：第二次相遇时slow走过的长度-第一次相遇时slow走过的长度，第二次相遇时A=2, x=2m; x2-x1=2m-m=m
	 * 
	 * 入口点算法：
	 * 由x=s+t=x=1*m=n-s, (即2s+t=n, 2(n-m)+t=n) (s+t)+(m-t)=n
	 * 另有一组指针pointer1和pointer2, pointer1从头开始走，pointer2从相遇点开始走，每次都各走一步
	 * 这两个指针将在loopEntry处相遇；
	 * 证明：当pointer1走到loopEntry时，走过了距离s, pointer2走到loopEntry时，走过了m-t; 由于s=m-t可知此时两点相遇
	 * 
	 * 总长：
	 * n=m+s, 即第一次slow走过的步数加第二次pointer2走过的步数
	 * 
	 */
	public boolean hasCycle_1_slowFastPointers(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(true){
			if(fast==null||fast.next==null) return false;
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)return true;
		}
    }
	public void hasCycle_1_slowFastPointers_extra(ListNode head) {
		boolean hasLoop=false;
		int length=0;
		int loopLength=0;
		ListNode loopEntry=null;
		
		ListNode slow=head;
		ListNode fast=head;
		int step_slow=0;
		while(true){
			if(fast==null||fast.next==null) {
				//hasLoop=false
				//loopEntry=null;
  				//loopLength=0;
				//length=step_slow*2;
				return; 
			}
			step_slow++;
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				hasLoop=true; //set result
				loopLength=step_slow; //set result
				break;
			}
		}
		ListNode pointer1=head;
		ListNode pointer2=slow;
		int step_pointer2=0;
		while(pointer1!=pointer2){
			step_pointer2++;
			pointer1=pointer1.next;
			pointer2=pointer2.next;
		}
		loopEntry=pointer2; //set result
		length=step_slow+step_pointer2;  //set result
		return;
    }
	
	/**
	 * TLE in Leetcode
	 * @param head
	 * @return
	 * Time: n*n maybe
	 * Space: O(1) (用记录位置的方法，节省了空间；也可使用O(n)space存储节点)
	 * 原理：使用两个指针 staticNode和localNode，并使用step1和step2分别记录两个指针距离头节点的距离
	 * staticNode是外层指针，一直向前走，每走一步step1++;
	 * localNode是内层指针，每次staticNode前进一步后，localNode从头开始走，一直走到staticNode==localNode为止，
	 * 	每走一步step2++;
	 * 当两个指针相等时，如果两个step相等，内层循环结束，staticNode继续向前；
	 * 如果有环，假设链表总长度为n，环的长度为m, 当step1=n+1时, 两指针相遇时，step2将等于n-m+1
	 * 如果无环，staticNode将走到null
	 * 
	 * 环的长度： m=(即将return true时的)step1-step2
	 * 链表长度： n=(即将return true时的)step1-1
	 * 环的入口： 相遇时的节点
	 */
	public boolean hasCycle_2_twoPointers(ListNode head) {
		ListNode staticNode=head;
		int step1=0;
		while(staticNode!=null){
			step1++;
			ListNode localNode=head;
			int step2=0;
			while(localNode!=null){
				step2++;
				if(staticNode==localNode){
					if(step1==step2) break;
					else return true;
				}
				localNode=localNode.next;
			}
			staticNode=staticNode.next;
		}
        return false;
    }
	public void hasCycle_2_twoPointers_extra(ListNode head) {
		boolean hasLoop=false;
		int length=0;
		int loopLength=0;
		ListNode loopEntry=null;
		
		ListNode staticNode=head;
		int step1=0;
		while(staticNode!=null){
			step1++;
			ListNode localNode=head;
			int step2=0;
			while(localNode!=null){
				step2++;
				if(staticNode==localNode){
					if(step1==step2) break;
					else {
						hasLoop=true;  //set result
						length=step1-1; //set result
						loopLength=step1-step2; //set result
						loopEntry=staticNode; //set result
						return;
					}
				}
				localNode=localNode.next;
			}
			staticNode=staticNode.next;
		}
		//hasLoop=false; //reset result
		//loopEntry=null; //reset result
		//loopLength=0; //reset result
		length=step1; //reset result 
        return;
    }
}
