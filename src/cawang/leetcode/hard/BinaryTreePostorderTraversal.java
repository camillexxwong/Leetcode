package cawang.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cawang.leetcode.structure.TreeNode;

public class BinaryTreePostorderTraversal {
/*    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack= new Stack<TreeNode>();
        Stack<TreeNode> stack_root= new Stack<TreeNode>();
        TreeNode temp=root;
        while(temp!=null||!stack.empty()||!stack_root.empty()){
            while(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            if(!stack_root.empty()){
                result.add(stack_root.pop().val);
            }
            temp=stack.pop();
            stack_root.push(temp);
            temp=temp.right;
        }
        return result;
    }*/
	public List<Integer> postorderTraversal_TwoStacks(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)return result;
        Stack<TreeNode> stack1= new Stack<TreeNode>();
        Stack<TreeNode> stack2= new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.empty()){
        /*	while(stack1.peek()==null){
        		stack1.pop();
        	}*/
            TreeNode temp=stack1.pop();
            stack2.push(temp);
            if(temp.left!=null)stack1.push(temp.left);
            if(temp.right!=null) stack1.push(temp.right);
        }
        while(!stack2.empty()){
        	result.add(stack2.pop().val);
        }
        return result;
    }
	
	public List<Integer> postorderTraversal_mark(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)return result;
        Stack<TreeNode> stack= new Stack<TreeNode>();
        TreeNode temp=root;
        TreeNode previsited=null;
        while(temp!=null||!stack.empty()){
        	while(temp!=null){
        		stack.push(temp);
        		temp=temp.left;
        	}
        	temp=stack.peek(); //!!
        	if(temp.right==null||temp.right==previsited){
        		result.add(temp.val);
        		previsited=temp;
        		stack.pop();
        		temp=null; //!!
        	}
        	else temp=temp.right;
        }
        return result;
    }
	
}
