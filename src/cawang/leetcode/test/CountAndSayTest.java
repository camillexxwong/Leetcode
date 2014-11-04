package cawang.leetcode.test;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cawang.leetcode.easy.CountAndSay;

public class CountAndSayTest {
	ArrayList<TestCase> testCases1=new ArrayList<TestCase>();
	ArrayList<TestCase> testCases=new ArrayList<TestCase>();
	CountAndSay testObj=new CountAndSay();
	private class TestCase implements ITestCase{
		int n;
		String result;
		TestCase(int n, String result){
			this.n=n;
			this.result=result;
		}
		@Override
		public Object[] getParams() {
			// TODO Auto-generated method stub
			Integer[] params={n};
			return params;
		}

		@Override
		public Object getResult() {
			// TODO Auto-generated method stub
			return result;
		}
		

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "The "+n+"th number of the count-say-sequece is expected to be: "+result;
		}
		
	}

	@Before
	public void setUp() throws Exception {
		testCases1.add(new TestCase(1,"1"));
		testCases1.add(new TestCase(2,"11"));
		testCases1.add(new TestCase(3,"21"));
		testCases1.add(new TestCase(4,"1211"));
		testCases1.add(new TestCase(5,"111221"));
		testCases1.add(new TestCase(6,"21112211"));
		
		testCases.add(new TestCase(1,"1"));
		testCases.add(new TestCase(2,"11"));
		testCases.add(new TestCase(3,"21"));
		testCases.add(new TestCase(4,"1211"));
		testCases.add(new TestCase(5,"111221"));
		testCases.add(new TestCase(6,"312211"));
		testCases.add(new TestCase(7,"13112221"));
		testCases.add(new TestCase(8,"1113213211"));
		testCases.add(new TestCase(9,"31131211131221"));
		testCases.add(new TestCase(10,"13211311123113112211"));
	}
	
	@Test
	public void testAll() throws Exception {
		TestUtil test=new TestUtil();

		//test.testAllMethodsOfObj(target, testCases);

		test.testMethodOfObj(testObj, testCases1,"countAndSay1_wrongunderstanding", int.class);
		//test.testMethodOfObjExcept(target, testCases,"countAndSay1_wrongunderstanding", int.class);
		test.testMethodOfObj(testObj, testCases,"countAndSay2_recursive", int.class);
		test.testMethodOfObj(testObj, testCases,"countAndSay3_nonrecursive", int.class);
	}
/*	@Test
	public void test1() throws Exception {
		TestUtil test=new TestUtil();

		test.testAllMethodsOfObj(target, testCases1);
	}*/
		

}
