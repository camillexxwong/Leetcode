package cawang.leetcode.test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import cawang.leetcode.easy.RemoveElement;



public class RemoveElementTest extends SuperUnitTest{
	ArrayList<TestCase> testCases=new ArrayList<TestCase>();
	RemoveElement removeEle=new RemoveElement();
	private class TestCase implements ITestCase{
		int result;
		int[] array;
		int element;
		public TestCase(int[] array, int element, int newLength){
			this.array=array;
			this.element=element;
			this.result=newLength;
		}
		
		public String toString(){
			return "Remove "+element+" from "+Arrays.toString(array)+", expected new length is "+result;
		}

		@Override
		public Object getResult() {
			// TODO Auto-generated method stub
			return this.result;
		}

		@Override
		public Object[] getParams() {
			// TODO Auto-generated method stub
			Object[] params=new Object[]{array, element};
			return params;
		}
		
	}
	@Before
	public void generateTestCases() throws Exception {
		testCases.add(new TestCase(new int[]{2},2,0));
		testCases.add(new TestCase(new int[]{2,2},2,0));
		testCases.add(new TestCase(new int[]{1,2,3,3,4,5,3,7,6,3},3,6));
		testCases.add(new TestCase(new int[]{1,2,3,3,4,5,3,7,6},3,6));


	}
	@Test
	public void testAll() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		TestUtil testUtil=new TestUtil();
		testUtil.testAllMethodsOfObj(removeEle, testCases);
		/*		Method[] targetMethods=RemoveElement.class.getDeclaredMethods();
		for(Method m:targetMethods){
			int caseIndex=0;
			for (TestCase t:testCases){
				String msg="Method: "+m.getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
				System.out.println(msg);
				assertEquals(msg, t.result,(Integer)m.invoke(removeEle, t.array,t.element));
			}
		}
*/
		
	}
	
/*	@Test
	public void testRemoveElement() {
		//fail("Not yet implemented");

		
	}*/

}
