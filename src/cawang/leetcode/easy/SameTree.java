package cawang.leetcode.easy;

public class SameTree {
	
	 /**
	  * Definition for binary tree
	  * @author cawang
	  *
	  */
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      public TreeNode(int x) { val = x; }
	      public TreeNode(int x, TreeNode left, TreeNode right) { 
	    	  val = x; 
	    	  this.left=left;
	    	  this.right=right;
	      }
	      public String toString(){
	    	  String prefix;
	    	  String value="";
	    	  String left="";
	    	  String right="";
/*	    	  if(value==null)value="null";
	    	  else value=String.valueOf(this.val);*/
	    	  if(this.left==null)left="null";
	    	  else left=this.left.toString();
	    	  if(this.right==null)right="null";
	    	  else right=this.right.toString();
	    	  
	    	  return "{tree_"+val+"_"+left+"_"+right+"}";
	      }
	  }
	 

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==q) return true;
		else if(p==null||q==null) return false;
		//else if(p.left ==q.left && p.right==q.right )return true;
		else return (p.val==q.val)
				&&isSameTree(p.left, q.left)
				&&isSameTree(p.right, q.right);
/*		else return (p.val==q.val)
		&&((p.left ==q.left)||isSameTree(p.left, q.left))
		&&((p.right==q.right) ||isSameTree(p.right, q.right));*/
	
		//return false;
		
	}
	
	public static boolean isSameTreeWrong(TreeNode p, TreeNode q) {
		if(p==q) return true;
		else if(p==null||q==null) return false;
		else if(p.val!=q.val) return false;
		else if(p.left ==q.left && p.right==q.right )return true;
		else if(p.left!=q.left){
			return isSameTree(p.left, q.left);
		}
		else {
			assert((p.right!=q.right));
			return isSameTree(p.right, q.right);
		}
		//return false;
	}

}
