package cawang.leetcode.easy;

import java.util.ArrayList;

import cawang.leetcode.structure.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        ArrayList<TreeNode> parents=new ArrayList<TreeNode>();
        ArrayList<TreeNode> children=new ArrayList<TreeNode>();
        ArrayList<Integer> line=new ArrayList<Integer>();
        parents.add(root);
        line.add(root.val);
        while(parents.size()>0){
         
            if(!isSym(line))return false;
            line.clear();
           // for(TreeNode p:parents){
            for(int i=0;i<parents.size();i++){
            	System.out.println(parents.size());
            	TreeNode p=parents.get(i);
                if(p==null)continue;//not break!
                children.add(p.left);
                children.add(p.right);
                line.add(p.left!=null?p.left.val:null);
                line.add(p.right!=null?p.right.val:null);
            }
            
            parents=children;
            //children.clear();//Cannot use children.clear(); will clear the obj that parent referring too!!
            children=new ArrayList<TreeNode>();
        }
        return true;
    }
    private boolean isSym(ArrayList<Integer> line){
        for(int i=0;i<line.size()/2;i++){
            Integer a=line.get(i);
            Integer b=line.get(line.size()-1-i);
            if(a!=null){
                if(!a.equals(b))return false;
            }else{
                if(b!=null)return false;
            }
        }
        return true;
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if(root==null)return true;
        return isSym2(root.left, root.right);
        
    }
    
    private boolean isSym2(TreeNode left, TreeNode right){ //Use 2 TreeNodes, didn't think it out bymyself
        if (left==null&&right==null)return true;
        if (left==null||right==null) return false;
        return (left.val==right.val)&&isSym2(left.left,right.right)&&isSym2(left.right,right.left); //Notice 3 coonditions
    }
    
    public static void  main(String[] args){
    	SymmetricTree obj=new SymmetricTree();
    	
    	TreeNode tree=new TreeNode(1);
    	tree.left=new TreeNode(2);
    	tree.right=null;
    	System.out.println(obj.isSymmetric(tree));
    	
    	TreeNode tree2=new TreeNode(1);
    	tree2.left=new TreeNode(2);
    	tree2.left.left=new TreeNode(3);
    	tree2.left.left.left=new TreeNode(4);
    	tree2.right=new TreeNode(2);
    	tree2.right.right=new TreeNode(3);
    	tree2.right.right.right=new TreeNode(4);
    	System.out.println(obj.isSymmetric(tree2));
    	
    	ArrayList<Integer> list2=new ArrayList<Integer>();
    	list2.add(6);
    	list2.add(null);
    	list2.add(null);
    	list2.add(6);
    	System.out.println(obj.isSym(list2));
    	
    }
}
