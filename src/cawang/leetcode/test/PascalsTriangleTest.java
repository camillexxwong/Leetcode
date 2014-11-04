package cawang.leetcode.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cawang.leetcode.easy.PascalsTriangle;



public class PascalsTriangleTest {

	ArrayList<TestCase> testCases=new ArrayList<TestCase>();
	PascalsTriangle testObj=new PascalsTriangle();
	private class TestCase implements ITestCase{
		List<List<Integer>> result;
		int numRows ;
		TestCase(int numRows , List<List<Integer>> result){
			this.numRows =numRows ;
			this.result=result;
		}
		@Override
		public Object[] getParams() {
			Object[] params={numRows};
			return params;
		}

		@Override
		public Object getResult() {
			return result;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "NumRows is: "+numRows+", expected result is"+result.toString();
		}
		
	}
	@Before
	public void setUp() throws Exception {
		int[][]triangle1={{1}};
		int[][]triangle2={{1},{1,1}};
		int[][]triangle3={{1},{1,1},{1,2,1}};
		int[][]triangle4={{1},{1,1},{1,2,1},{1,3,3,1}};
		int[][]triangle5={{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1}};
		int[][]triangle6={{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1},{1,5,10,10,5,1}};

		int[][][] ints={triangle1,triangle2,triangle3,triangle4,triangle5,
				triangle6};
		
		ArrayList<List<List<Integer>>> lists=new ArrayList<List<List<Integer>>>(ints.length);
		for(int i=0;i<ints.length;i++){
			lists.add(TestUtil.toList(ints[i]));
		}
		
		for(int j=0;j<lists.size();j++){
			testCases.add(new TestCase(j+1,lists.get(j)));
		}

	}

	@Test
	public void testAll() throws Exception {
		TestUtil test=new TestUtil();
		//assertEquals(new int[]{1,0},testObj.plusOne(new int[]{9}));
		test.testAllMethodsOfObj(testObj, testCases);
	}
}
