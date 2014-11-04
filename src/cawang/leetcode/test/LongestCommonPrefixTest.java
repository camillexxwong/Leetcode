package cawang.leetcode.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cawang.leetcode.easy.LongestCommonPrefix;





public class LongestCommonPrefixTest {
	private static LongestCommonPrefix testObj=new LongestCommonPrefix();
	static ArrayList<TestCase> testCases=new ArrayList<TestCase>(10);
	public static int staticCount=0;
	public  int count=0;
	
	public LongestCommonPrefixTest(){
		super();
		System.out.println("Constructor of LongestCommonPrefixTest");
		staticCount++;
		count++;
	}
	
	private static class TestCase implements ITestCase{
		String[] strs;
		String result;
		TestCase(String[] strs, String result){
			this.strs=strs;
			this.result=result;
		}
		
		public String toString(){
			return Arrays.toString(strs)+", "+this.result;
		}

		@Override
		public Object getResult() {
			return this.result;
		}

		@Override
		public Object[] getParams() {
			Object[] params={strs};
			return params;
		}
	}
	
	public class Cases{
		String[] source1=new String[]{"a"};
		String result1="a";
		String[] source2=new String[]{"a","a"};
		String result2="a";
		String[] source3=new String[]{"ab","bc"};
		String result3="";
		String[] source4=null;
		String result4="";
		String[] source5=new String[]{"abc","ab","abd","abee"};
		String result5="ab";
		String[] source6=new String[]{"b","ab","abd","abee"};
		String result6="";
		String[] source7=new String[]{"ab","ab","abd","b"};
		String result7="";
	}
	@Before
	public void generateTestCases() throws IllegalArgumentException, IllegalAccessException{
		Cases objCases=new Cases();
		Field[] fields=Cases.class.getDeclaredFields();
		ArrayList<String[]> sources=new ArrayList<String[]>();
		ArrayList<String> results=new ArrayList<String>();
		for(Field f:fields){
			if(f.getName().contains("source"))sources.add((String[])f.get(objCases));
			else if(f.getName().contains("result"))results.add((String)f.get(objCases));
		}
		
		for(int i=0;i<sources.size();i++){
			testCases.add(new TestCase(sources.get(i),results.get(i)));
		}
	}

	@Test
	public void testAll() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestUtil test=new TestUtil();
		test.testAllMethodsOfObj(testObj, testCases);
	}

}
