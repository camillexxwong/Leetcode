package cawang.leetcode.easy;

import org.junit.Test;

public class MergeTwoSortedLists {
	
	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	      ListNode(int[] array){
	    	  for(int i=0;i<array.length-1;i++){
	    		  val=array[i];
	    		  next=new ListNode(array[i+1]);
	    		  
	    	  }
	      }
		  public String toString(){
			  StringBuilder s=new StringBuilder("");
			
			  ListNode temp=this;
			  while(temp!=null){
				
				  s.append(",");
				  s.append(temp.val);
				  temp=temp.next;
			  }
			  return s.toString();
		  }
	  }
	  

	  @Test
	  public void test(){
		  ListNode l1=new ListNode(0);
		  ListNode l2=new ListNode(1);
		  System.out.println(mergeTwoLists(l1, l2));
		  ListNode l3=new ListNode(new int[]{1,2,4});
		  ListNode l4=new ListNode(5);
		  System.out.println(l3);
		  System.out.println(l4);
		  System.out.println(mergeTwoLists(l4, l3));
		  ListNode l5=new ListNode(new int[]{1,3,4,8,9,10});
		  ListNode l6=new ListNode(new int[]{2,5,6,7,12,13});
	  }
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          if(l1==null)return l2;
		  if(l2==null) return l1;
		  //ListNode head=l1.val<l2.val?l1:l2; //infinite loop
		  ListNode head;
		  ListNode temp1=l1;
	      ListNode temp2=l2;
		  if(l1.val<l2.val){
		      head=l1;
		      temp1=l1.next;
		  }
		   else{
		      head=l2;
		      temp2=l2.next;
		  }
		  ListNode temp=head;
	      while(temp1!=null&&temp2!=null){ //Change to &&, no need to do more things if one list reach end
	            if(temp1.val<temp2.val){
	                temp.next=temp1;
	                temp1=temp1.next;
	            }
	            else{
	                temp.next=temp2;
	                temp2=temp2.next;
	            }
	            temp=temp.next;
	        }
	        return head;
	  }

	  
	  //Improve, no dummy head; less compare
	  public ListNode _mergeTwoLists(ListNode l1, ListNode l2) {
          if(l1==null)return l2;
		  if(l2==null) return l1;
		  //ListNode head=l1.val<l2.val?l1:l2; //infinite loop
		  ListNode head;
		  ListNode temp1=l1;
	      ListNode temp2=l2;
		  if(l1.val<l2.val){
		      head=l1;
		      temp1=l1.next;
		  }
		   else{
		      head=l2;
		      temp2=l2.next;
		  }
		  ListNode temp=head;
	      while(temp1!=null&&temp2!=null){ //Change to &&, no need to do more things if one list reach end
	            if(temp1.val<temp2.val){
	                temp.next=temp1;
	                while(temp1.next!=null&&temp1.next.val<temp2.val){
	                	temp1=temp1.next;
	                }
	                temp=temp1;
	            }
	            else{
	                temp.next=temp2;
	                while(temp2.next!=null&&temp2.next.val<temp1.val){
	                	temp2=temp2.next;
	                }
	                temp=temp2;
	            }
	        }
	        return head;
	  }

	//One time AC, Merge Sort method
    public ListNode mergeTwoLists_v1(ListNode l1, ListNode l2) {
	       
	        ListNode head=new ListNode(-1); //trick, very important!!
	        ListNode temp=head;
	        ListNode temp1=l1;
	        ListNode temp2=l2;
	        while(temp1!=null||temp2!=null){
	            if(temp1==null){
	                temp.next=temp2;
	                temp2=temp2.next;
	                
	            }
	            else if (temp2==null){
	                temp.next=temp1;
	                temp1=temp1.next;
	            }
	            else if(temp1.val<temp2.val){
	                temp.next=temp1;
	                temp1=temp1.next;
	            }
	            else{
	                temp.next=temp2;
	                temp2=temp2.next;
	            }
	            temp=temp.next;
	        }
	        return head.next; //trick, very important!!
	    }
}
