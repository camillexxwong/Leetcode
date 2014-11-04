package cawang.leetcode.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class TestUtil {
	public <T extends ITestCase,S> void testAllMethodsOfObj (S testObj, ArrayList<T> testCases) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] targetMethods=testObj.getClass().getDeclaredMethods();
		for(Method m:targetMethods){
			int caseIndex=0;
			for (T t:testCases){
				if(m.getName().startsWith("_")) continue;
				String msg="Method: "+m.getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
				System.out.println(msg);
				//deal with arrays
				if(t.getResult().getClass()==int[].class){
					int[] r=(int[])t.getResult();
					int[] actual=(int[])m.invoke(testObj, t.getParams());
					assertEquals("length not equal", r.length, actual.length);
					for(int i=0;i<r.length;i++){
						assertEquals(msg+", digit "+i, r[i],actual[i]);
					}
				}
				else assertEquals(msg, t.getResult(),m.invoke(testObj, t.getParams()));
			}
		}
	}
	
//Simpliest
/*	public class TestUtil {
		public <T extends ITestCase,S> void testAllMethodsOfObj (S testObj, ArrayList<T> testCases) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Method[] targetMethods=testObj.getClass().getDeclaredMethods();
			for(Method m:targetMethods){
				int caseIndex=0;
				for (T t:testCases){
					String msg="Method: "+m.getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
					System.out.println(msg);
					assertEquals(msg, t.getResult(),m.invoke(testObj, t.getParams()));
				}
			}
		}
		*/
/*	public <T extends ITestCase,S> void testAllMethodsOfObj (S testObj, ArrayList<T> testCases) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		testMethodOfObjExcept(testObj,testCases,"");
	}*/
	
	public <T extends ITestCase,S> void testMethodOfObj (S testObj, ArrayList<T> testCases, String methodName, Class ... paramTypes) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method targetMethod=testObj.getClass().getDeclaredMethod(methodName, paramTypes);
			int caseIndex=0;
			for (T t:testCases){
				String msg="Method: "+targetMethod.getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
				System.out.println(msg);
				assertEquals(msg, t.getResult(),targetMethod.invoke(testObj, t.getParams()));
			}
	}
	
	//Not good
/*	public <T extends ITestCase,S> void testMethodOfObjExcept (S testObj, ArrayList<T> testCases, String methodName, Class ... paramTypes) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method[] targetMethods=testObj.getClass().getDeclaredMethods();
		Method ignoreMethod;
		if(methodName==""){
			ignoreMethod=null;
		}
		else ignoreMethod=testObj.getClass().getDeclaredMethod(methodName, paramTypes);
		
		for(Method m:targetMethods){
			if( ignoreMethod!=null&&m.getName().equals(ignoreMethod.getName()))return;
			int caseIndex=0;
			for (T t:testCases){
				String msg="Method: "+m.getName()+"; TestCase"+(++caseIndex)+": "+t.toString();
				System.out.println(msg);
				assertEquals(msg, t.getResult(),m.invoke(testObj, t.getParams()));
			}
		}

	}*/
	
	private Integer[] parseInts(int[] ori){
		Integer[] wrapper=new Integer[ori.length];
		for(int i:ori){
			wrapper[i]=Integer.valueOf(ori[i]);
		}
		return wrapper;
	}
	
	public static List<List<Integer>> toList(int[][] array){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		for(int i=0;i<array.length;i++){
			List<Integer> innerList=new ArrayList<Integer>();
			for(int j=0;j<array[i].length;j++){
				innerList.add(array[i][j]);
			}
			list.add(innerList);
		}
		return list;
	}
}
