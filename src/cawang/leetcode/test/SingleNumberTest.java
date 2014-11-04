/**
 * 
 */
package cawang.leetcode.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cawang.leetcode.medium.SingleNumber;

/**
 * @author cawang
 *
 */
public class SingleNumberTest {
	private int[] A1={1,2,-3,-3,1,0,0};

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link cawang.leetcode.medium.SingleNumber#singleNumber(int[])}.
	 */
	@Test
	public void testSingleNumber() {
		assertEquals(2,SingleNumber.singleNumber(A1));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cawang.leetcode.medium.SingleNumber#singleNumber1(int[])}.
	 */
	@Test
	public void testSingleNumber1() {
		assertEquals(2,SingleNumber.singleNumber(A1));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cawang.leetcode.medium.SingleNumber#singleNumber2(int[])}.
	 */
	@Test
	public void testSingleNumber2() {
		assertEquals(2,SingleNumber.singleNumber(A1));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link cawang.leetcode.medium.SingleNumber#singleNumber3(int[])}.
	 */
	@Test
	public void testSingleNumber3() {
		assertEquals(2,SingleNumber.singleNumber(A1));
		//fail("Not yet implemented");
	}

}
