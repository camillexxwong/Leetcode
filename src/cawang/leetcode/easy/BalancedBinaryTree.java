package cawang.leetcode.easy;

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
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        return isBalanced_1_recursive(root);
    }
    
    public boolean isBalanced_1_recursive(TreeNode root) {
        if(root==null) return true;
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1;
    }
    private int depth(TreeNode node){
        if(node==null) return 0;
        return Math.max(1+depth(node.left), 1+depth(node.right));
    }
}
