package cawang.leetcode.structure;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode generateList(int[] array){
		if(array==null||array.length==0) return null;
		ListNode head=new ListNode(array[0]);
		ListNode temp=head;
		for(int i=1;i<array.length;i++){
			temp.next=new ListNode(array[i]);
			temp=temp.next;
		}
		return head;
	}
	
	public String toString(){
		StringBuilder result=new StringBuilder("");
		ListNode temp=this;
		while(temp!=null){
			result.append(temp.val);
			temp=temp.next;
		}
		return result.toString();
	}
}
