package cawang.leetcode.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import cawang.leetcode.easy.PlusOne;


public class PlusOneTest {
	ArrayList<TestCase> testCases=new ArrayList<TestCase>();
	PlusOne testObj=new PlusOne();
	private class TestCase implements ITestCase{
		int[] result;
		int[] digits;
		TestCase(int[] digits, int[] result){
			this.digits=digits;
			this.result=result;
		}
		@Override
		public Object[] getParams() {
			Object[] params={digits};
			return params;
		}

		@Override
		public Object getResult() {
			return result;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Original number is: "+Arrays.toString(digits)+", new number is"+Arrays.toString(result);
		}
		
	}
	@Before
	public void setUp() throws Exception {
		testCases.add(new TestCase(new int[]{0},new int[]{1}));
		testCases.add(new TestCase(new int[]{9},new int[]{1,0}));
		testCases.add(new TestCase(new int[]{9,9,9,9},new int[]{1,0,0,0,0}));
		testCases.add(new TestCase(new int[]{1,2,3,9},new int[]{1,2,4,0}));
		testCases.add(new TestCase(new int[]{9,1,9,2,3,9},new int[]{9,1,9,2,4,0}));
	}
	@Test
	public void testAll() throws Exception {
		TestUtil test=new TestUtil();
		//assertEquals(new int[]{1,0},testObj.plusOne(new int[]{9}));
		test.testAllMethodsOfObj(testObj, testCases);
	}
}
