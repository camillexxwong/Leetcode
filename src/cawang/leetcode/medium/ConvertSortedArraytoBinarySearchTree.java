package cawang.leetcode.medium;

import cawang.leetcode.structure.TreeNode;

/**
 * 
 * @author cawang
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

	Hide Tags Tree Depth-first Search

 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	/**
	 * 
	 * @param num
	 * @return
	 * similar method as make BinaryTree by In-Order traverse
	 * 完全二叉树深度：log2n+1, 2是底数
	 */
    public TreeNode sortedArrayToBST(int[] num) {
    	//return sortedArrayToBST_1_recursive(num);
    	return sortedArrayToBST_2_nonrecursive(num);
    }
    
    /**
     * 递归
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST_1_recursive(int[] num) {
    	if(num==null||num.length==0) return null;
    	int length=num.length;
        TreeNode root=sortedArrayToBST_1_helper(num, 0,length-1);
        return root;
    }
    private TreeNode sortedArrayToBST_1_helper(int[] num, int startIdx, int endIdx) {
    	if(startIdx==endIdx) return new TreeNode(num[startIdx]); 
    	//when 2 elements left, next time left child start>end
    	if(startIdx>endIdx) return null;
    	int rootIdx=startIdx+(endIdx-startIdx)/2;
        TreeNode root=new TreeNode(num[rootIdx]);
        root.left=sortedArrayToBST_1_helper(num,startIdx,rootIdx-1);
        root.right=sortedArrayToBST_1_helper(num,rootIdx+1,endIdx);
        return root;
    }
    
    /**
	 * TODO!!
	 * @param num
	 * @return
	 * similar method as make BinaryTree by In-Order traverse
	 * 完全二叉树深度：log2n+1, 2是底数
	 */
    public TreeNode sortedArrayToBST_2_nonrecursive(int[] num) {
    	if(num==null||num.length==0) return null;
    	int length=num.length;
        TreeNode root=new TreeNode(0);
        return root;
    }
    
}
