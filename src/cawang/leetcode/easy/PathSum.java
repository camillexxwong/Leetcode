package cawang.leetcode.easy;

import java.util.Stack;

public class PathSum {
	
	 public class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	 public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum_noRecursive(root,sum);
	 }
	 private boolean hasPathSum_noRecursive(TreeNode root, int sum) {
        if(root==null)return false;
        int currentSum=0;
        TreeNode temp=root;
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        Stack<Integer> sums=new Stack<Integer>();
        while(temp!=null||!nodes.empty()){
            currentSum+=temp.val;
            if(temp.left==null&&temp.right==null){
                if(currentSum==sum)return true;
                if(!nodes.empty()){
                    currentSum=sums.pop();
                    temp=nodes.pop();
                    temp=temp.right;
                }
                else return false; //don't forget this line
            }
            else if(temp.left!=null&&temp.right!=null){
                nodes.push(temp);
                sums.push(currentSum);
                temp=temp.left;
                
            }
            else if(temp.left!=null){
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }
        }
        
        return false;
    }
	 
	 private boolean hasPathSum_recursive(TreeNode root, int sum) {
       if(root==null)return false;
       if(root.left==null&&root.right==null){
           return sum==root.val;
       }
		 else {
			int currentSum=root.val;
			if(hasPathSum_recursive(root.left,sum-currentSum))return true;
			if(hasPathSum_recursive(root.right,sum-currentSum))return true;
			return false;
		 }
	 }
	 
	 private boolean hasPathSum_wrong(TreeNode root, int sum) {
    	 int currentSum=root.val;
		 if(root==null)return (sum-currentSum==0);
			hasPathSum(root.left,sum-currentSum);
			hasPathSum(root.right,sum-currentSum);
		 return false;
	    }
	
	 public static void main(String... args) {
		 PathSum p=new PathSum();
		 TreeNode root=p.new TreeNode(1);
		 
		 System.out.println(p.hasPathSum_noRecursive(root,1));
	 }
}
