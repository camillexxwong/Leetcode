package cawang.leetcode.easy;

import java.util.Stack;

import cawang.leetcode.structure.TreeNode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		//return minDepth_1(root);
		//return minDepth_2(root);
		return minDepth_3_recursive(root);
	}
	public int minDepth_1(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        Stack<Integer> storedSums=new Stack<Integer>();
        int min=1; //not 0
        TreeNode temp=root;
        int currentSum=0;
        
        while(temp!=null||!nodes.empty()){
            currentSum++;
            if(temp.left==null&&temp.right==null){
            	 	min=currentSum<min||min==1?currentSum:min; //add min==1
                    if(!nodes.empty()){
                        currentSum=storedSums.pop();
                        temp=nodes.pop().right;
                    }
                    else return min;  //end loop when temp is leaf and nodes is empty
            }
            else if(temp.left!=null&&temp.right!=null){ //only push nodes and sotre sums when node has both left and right
                nodes.push(temp);
                storedSums.push(currentSum); //notice
                temp=temp.left;
            }
            else if(temp.left!=null){
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }
        }
        
        return min;
    }
	public int minDepth_2wrong(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> nodes=new Stack<TreeNode>();
       // Stack<Integer> storedSums=new Stack<Integer>();
        int min=1; //not 0
        TreeNode temp=root;
        nodes.push(temp);
        int currentSum=1;
        while(temp!=null||!nodes.empty()){
            while(temp!=null){
            	nodes.push(temp);
            	currentSum++;
            	if(temp.left==null&&temp.right==null){
            		min=currentSum<min||min==1?currentSum:min;
            		nodes.pop();
            		currentSum--;
            	}
            	temp=temp.left;
            }
            temp=nodes.pop();
            currentSum--;
            temp=temp.right;
        }
        
        return min;
    }
	
	public int minDepth_3_recursive(TreeNode root) {
/*		if(root==null) return 0;
		int min=1;
		min=Math.min(1+minDepth_3_recursive(root.left), 1+minDepth_3_recursive(root.right));
		return min;*/ //wrong: {1,2}->1, expected 2
		if(root==null) return 0;
		int left=minDepth_3_recursive(root.left);
		int right=minDepth_3_recursive(root.right);
		int min;
		if(left!=0&&right!=0)min=Math.min(left,right);
		else min=Math.max(left,right);
		return 1+min;
	}
}
