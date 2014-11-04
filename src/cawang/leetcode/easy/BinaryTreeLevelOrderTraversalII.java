package cawang.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import cawang.leetcode.structure.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		//return levelOrderBottom_1(root);
		return levelOrderBottom_2(root);
  	}
    /**
     * @param root
     * @return
     * use 1 queue + 1 stack
     * from right to left
     */
    public List<List<Integer>> levelOrderBottom_1(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> innerresult=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        
        TreeNode temp=root;
        queue.add(temp);
        queue.add(null); //notice： {1,2}->{{1},{2}}
        while(!queue.isEmpty()){ //delete temp!=null||
        	stack.push(queue.poll()); //move to common area, instead of innerresult.add(queue.poll().val);
        	if(temp==null){
        		if(!queue.isEmpty()) queue.add(null);  
        	}
        	else{
            	//innerresult.add(queue.poll().val);
        		if(temp.right!=null) queue.add(temp.right); //right first!!
            	if(temp.left!=null)  queue.add(temp.left);
            }
        	temp=queue.peek();
        }
        
        stack.pop(); //pop the 1st null
        while(!stack.empty()){
        	TreeNode top=stack.pop(); //cannot use in both if and else, will pop() twice
        	if(top==null){
        		result.add(innerresult);
        		innerresult=new ArrayList<Integer>(); //safe after all
        	}
        	else	innerresult.add(top.val);
        }
        result.add(innerresult); //last line
        return result;
    }
    
    public List<List<Integer>> levelOrderBottom_2(TreeNode root) {
    	if(root==null) return new ArrayList<List<Integer>>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> innerresult=new ArrayList<Integer>();
       // Stack<TreeNode> stack=new Stack<TreeNode>();
        List<TreeNode> stack=new CopyOnWriteArrayList<TreeNode>();
        ListIterator<TreeNode> lit=stack.listIterator();
        TreeNode temp=root;
        stack.add(temp);
        stack.add(null); //notice： {1,2}->{{1},{2}}
        while(!stack.isEmpty()){ //delete temp!=null||
        	temp=lit.next(); //!!
        	if(temp==null){
        		if(!stack.isEmpty()) stack.add(null);  
        	}
        	else{
            	//innerresult.add(queue.poll().val);
        		if(temp.right!=null) stack.add(temp.right); //right first!!
            	if(temp.left!=null)  stack.add(temp.left);
            }
        }
        
        stack.remove(stack.size()-1);//pop the 1st null
        while(stack.size()>0){
        	TreeNode top=stack.remove(stack.size()-1); //cannot use in both if and else, will pop() twice
        	if(top==null){
        		result.add(innerresult);
        		innerresult=new ArrayList<Integer>();
        	}
        	else	innerresult.add(top.val);
        }
        result.add(innerresult); //last line
        return result;
    }
}
