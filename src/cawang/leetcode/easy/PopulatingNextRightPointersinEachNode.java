package cawang.leetcode.easy;

import java.util.Stack;

import cawang.leetcode.structure.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        // connect_1_recursive(root);
     	//connect_2_nonrecursive(root);
     	connect_3_nonrecursive_O1(root);
     }
     
     //Depth first
     public void connect_1_recursive(TreeLinkNode root) {
          if(root==null||root.left==null) return;
          root.left.next=root.right;
          if(root.next!=null)root.right.next=root.next.left;
          connect_1_recursive(root.left);
          connect_1_recursive(root.right);
     }
     
     public void connect_2_nonrecursive_wrong(TreeLinkNode root) {
         TreeLinkNode temp=root;
         TreeLinkNode parent=null;
         while(temp!=null){
         	if(temp.left==null){
         		if(parent==null||parent.next==null)return; //notice
         		temp=parent.next;
         		continue;//notice
         	}
 	        temp.left.next=temp.right;
 	        if(temp.next!=null)temp.right.next=temp.next.left;
 	        parent=temp;
 	        temp=temp.left;
         }
    }
     
     //Depth first, space: O(n), similar as pre-order traverse
     public void connect_2_nonrecursive(TreeLinkNode root) {
         TreeLinkNode temp=root;
         Stack<TreeLinkNode> stack=new Stack<TreeLinkNode>();
         while((temp!=null&&temp.left!=null)||!stack.empty()){
         	while(temp!=null&&temp.left!=null){
         		stack.push(temp);
 		        temp.left.next=temp.right;
 		        if(temp.next!=null)temp.right.next=temp.next.left;
 		        temp=temp.left;
         	}
         	temp=stack.pop();
         	temp=temp.right;
         }
    }

     //Level first , Space: O(1)   
    public void connect_3_nonrecursive_O1(TreeLinkNode root) {
     	TreeLinkNode nextLevel=root;
     	while(nextLevel!=null){
     		if(nextLevel.left==null) return;
 			TreeLinkNode nextSibling=nextLevel;
 			while(nextSibling!=null){
 				nextSibling.left.next=nextSibling.right;
 				if(nextSibling.next!=null){
 					nextSibling.right.next=nextSibling.next.left;
 				}
 				nextSibling=nextSibling.next;				
 			}
 			nextLevel=nextLevel.left;
     	}
     }
     /*
     public void connect_3_nonrecursive_O1(TreeLinkNode root) {
     	if(root==null)return;
     	TreeLinkNode nextSibling=root;
     	TreeLinkNode nextLevel=null;
     	while(nextSibling!=null){
     		if(nextSibling.left==null) return;
 			nextLevel=nextSibling.left;
 			while(nextSibling!=null){
 				nextSibling.left.next=nextSibling.right;
 				if(nextSibling.next!=null){
 					nextSibling.right=nextSibling.next.left;
 				}
 				nextSibling=nextSibling.next;				
 			}
 			nextSibling=nextLevel;
     	}
     }*/
}
