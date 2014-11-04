package cawang.leetcode.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cawang.leetcode.easy.SameTree;
import cawang.leetcode.easy.SameTree.TreeNode;

//import Leetcode.SameTree.TreeNode;

public class SameTreeTest {
	private static SameTree sameTree=new SameTree();
	static ArrayList<TestCase> testCases=new ArrayList<TestCase>(10);
	public static int staticCount=0;
	public  int count=0;
	
	public SameTreeTest(){
		super();
		System.out.println("Constructor of SameTreeTest");
		staticCount++;
		count++;
	}
	
	private static class TestCase{
		SameTree.TreeNode tree1;
		SameTree.TreeNode tree2;
		boolean result;
		TestCase(SameTree.TreeNode tree1, SameTree.TreeNode tree2, boolean result){
			this.tree1=tree1;
			this.tree2=tree2;
			this.result=result;
		}
		
		public String toString(){
			return this.tree1+", "+this.tree2+", "+this.result;
		}
	}
	

	@BeforeClass
	public  static void generateTestCases() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Set Up");
		SameTree.TreeNode tree_0=sameTree.new TreeNode(0);
		SameTree.TreeNode tree_null=null;
		SameTree.TreeNode tree_nullb=null;
		SameTree.TreeNode tree_1=sameTree.new TreeNode(1);
		SameTree.TreeNode tree_1b=sameTree.new TreeNode(1);
		SameTree.TreeNode tree_0b=sameTree.new TreeNode(0);
		SameTree.TreeNode tree_0_1=sameTree.new TreeNode(0,tree_0, tree_1);		
		SameTree.TreeNode tree_1_0=sameTree.new TreeNode(0,tree_1, tree_0);	
		SameTree.TreeNode tree_0b_1=sameTree.new TreeNode(0,tree_0b, tree_1);	
		SameTree.TreeNode tree_0b_0=sameTree.new TreeNode(0,tree_0b, tree_0);	
		SameTree.TreeNode tree_1_1b=sameTree.new TreeNode(0,tree_1, tree_1b);
		
		testCases.add(new TestCase(tree_0,tree_0,true));
		testCases.add(new TestCase(tree_0,tree_null,false));
		testCases.add(new TestCase(tree_nullb,tree_null,true));
		testCases.add(new TestCase(tree_0,tree_0_1,false));
		testCases.add(new TestCase(tree_0_1, tree_1_0,false));
		testCases.add(new TestCase(tree_0_1,tree_0b_1,true));
		testCases.add(new TestCase(tree_0_1,tree_0b_0,false));
		testCases.add(new TestCase(tree_0_1,tree_1_1b,false));


		
	}

	@Test
	public void testAll() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println(testCases.size());
		Method[] targetMethods=SameTree.class.getDeclaredMethods();
		for(Method m:targetMethods){
			int caseIndex=0;
			for (TestCase t:testCases){
				String msg="Method: "+m.getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
				System.out.println(msg);
				assertEquals(msg, t.result,(Boolean)m.invoke(sameTree, t.tree1,t.tree2));
			}
			System.out.println(m.getName()+"() passes!");
		}
	}

	@Test
	public void  testFlow(){
		System.out.println(testCases.size());
		SameTree.TreeNode tree_0=sameTree.new TreeNode(0);
		testCases.add(new TestCase(tree_0,tree_0,true));
		System.out.println(testCases.size());
		
		System.out.println("staticCount: "+staticCount);
		System.out.println("count: "+count);
	}
/*	@Test
	public void testIsSameTree() {
		//fail("Not yet implemented");
		SameTree sameTree=new SameTree();
		SameTree.TreeNode tree1=sameTree.new TreeNode(0);
		SameTree.TreeNode tree2=null;
		SameTree.TreeNode tree3=null;
		SameTree.TreeNode tree4=sameTree.new TreeNode(1);
		SameTree.TreeNode tree8=sameTree.new TreeNode(0);
		SameTree.TreeNode tree5=sameTree.new TreeNode(0,tree1, tree4);		
		SameTree.TreeNode tree6=sameTree.new TreeNode(0,tree4, tree1);	
		SameTree.TreeNode tree7=sameTree.new TreeNode(0,tree8, tree4);	
		SameTree.TreeNode tree9=sameTree.new TreeNode(0,tree8, tree1);	
		
		assertTrue(SameTree.isSameTree(tree1, tree1));
		assertTrue(SameTree.isSameTree(tree1, tree1));
		assertTrue(!SameTree.isSameTree(tree1, tree2));
		assertTrue(SameTree.isSameTree(tree3, tree2));
		assertTrue(!SameTree.isSameTree(tree1, tree4));
		assertTrue(!SameTree.isSameTree(tree1, tree5));
		assertTrue(!SameTree.isSameTree(tree5, tree6));
		assertTrue(SameTree.isSameTree(tree5, tree7));
		assertTrue(!SameTree.isSameTree(tree5, tree9));
	}*/
	
/*	@Test
	public void testIsSameTreeWrong() {
		//fail("Not yet implemented");
		SameTree sameTree=new SameTree();
		SameTree.TreeNode tree1=sameTree.new TreeNode(0);
		SameTree.TreeNode tree2=null;
		SameTree.TreeNode tree3=null;
		SameTree.TreeNode tree4=sameTree.new TreeNode(1);
		SameTree.TreeNode tree8=sameTree.new TreeNode(0);
		SameTree.TreeNode tree5=sameTree.new TreeNode(0,tree1, tree4);		
		SameTree.TreeNode tree6=sameTree.new TreeNode(0,tree4, tree1);	
		SameTree.TreeNode tree7=sameTree.new TreeNode(0,tree8, tree4);	
		SameTree.TreeNode tree9=sameTree.new TreeNode(0,tree8, tree1);	
		
		assertTrue(SameTree.isSameTreeWrong(tree1, tree1));
		assertTrue(SameTree.isSameTreeWrong(tree1, tree1));
		assertTrue(!SameTree.isSameTreeWrong(tree1, tree2));
		assertTrue(SameTree.isSameTreeWrong(tree3, tree2));
		assertTrue(!SameTree.isSameTreeWrong(tree1, tree4));
		assertTrue(!SameTree.isSameTreeWrong(tree1, tree5));
		assertTrue(!SameTree.isSameTreeWrong(tree5, tree6));
		assertTrue(SameTree.isSameTreeWrong(tree5, tree7));
		assertTrue(!SameTree.isSameTreeWrong(tree5, tree9));
	}*/

}
