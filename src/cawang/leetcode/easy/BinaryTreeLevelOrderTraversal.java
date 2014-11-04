package cawang.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cawang.leetcode.structure.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		return levelOrder_2(root);
	}
		
	public List<List<Integer>> levelOrder_2(TreeNode root) {
		if(root==null) return new ArrayList<List<Integer>>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> innerresult=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        
        TreeNode temp=root;
        queue.add(temp);
        queue.add(null); //notice： {1,2}->{{1},{2}}
        while(!queue.isEmpty()){ //delete temp!=null||
        	if(temp==null){
        		//if(innerresult.size()==0) return result;
        		queue.poll();
        		List<Integer> templ=innerresult;  //notice collection storing reference
        		result.add(templ);
        		if(!queue.isEmpty()){ //notice!!
        			innerresult=new ArrayList<Integer>();
        			queue.add(null);  //here to add null, important!!
        		}
        	}
        	else{
            	innerresult.add(queue.poll().val);
            	if(temp.left!=null)  queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right); 
            }
        	temp=queue.peek();
        }
        return result;
	}
	
	public List<List<Integer>> levelOrder_wrong(TreeNode root) {
    	if(root==null) return new ArrayList<List<Integer>>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> innerresult=new ArrayList<Integer>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode temp=root;
        TreeNode lineend=root;
        TreeNode lastleft=null;
        queue.add(temp);
        queue.add(null); //notice： {1,2}->{{1},{2}}
        while(!queue.isEmpty()){ //delete temp!=null||
        	if(temp==null){
        		if(innerresult.size()==0) return result;
        		queue.poll();
        		List<Integer> templ=innerresult;
        		result.add(templ);
        		innerresult=new ArrayList<Integer>();
        	}
        	else{
            	innerresult.add(queue.poll().val);
            	if(temp.left!=null){
                    queue.add(temp.left);
                    lastleft=temp.left;
                }
                if(temp.right!=null&&temp==lineend){
                    queue.add(temp.right); 
                    /*lineend=temp.right;
                    queue.add(null);*///{1,2,3,4,5}->[[1],[2,3],[4,5]] not [[1],[2,3],[4]]
                }
                if(temp==lineend){
                    lineend=temp.right!=null?temp.right:lastleft;
                    if(lineend!=null)queue.add(null); //{1}->[[1]], not [[1],[]]
                }
        	}
        	temp=queue.peek();
        }
        if(innerresult.size()>0) //{1}->[[1]], not [[1],[]]
            result.add(innerresult); //don't forget last line
        return result;
    }
}
