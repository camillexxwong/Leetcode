package cawang.leetcode.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import cawang.leetcode.easy.ReverseInteger;

public class ReverseIntegerTest {
	private HashMap<Integer, Integer> resultMap=new HashMap<Integer, Integer>();
/*	ReverseIntegerTest() {

	resultMap.put(123,321);
}*/
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		resultMap.put(1230,321);
		resultMap.put(1022,2201);
		resultMap.put(-123,-321);
		resultMap.put(123,321);
		resultMap.put(00,0);
		//resultMap.put(1111111119,0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Test
	public void testReverse() {
		Iterator it=resultMap.keySet().iterator();
		while(it.hasNext()){
			int key = (Integer)it.next();
			int value=(Integer)resultMap.get(key);
			System.out.println(key+"   "+value+"   "+ReverseInteger.reverse(key));
			assertEquals(value, ReverseInteger.reverse(key));
		}
		//fail("Not yet implemented");
	}

	@Test
	public void testReverse1() {
		//fail("Not yet implemented");
	}

}
