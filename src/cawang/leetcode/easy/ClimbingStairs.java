/**
 * 
 */
package cawang.leetcode.easy;

import java.util.Vector;
//import static java.lang.System.out;

/**
 * @author cawang
 * 
 */
public class ClimbingStairs {
	/**
	 * 
	 */
	private int[] temp;  
    public int climbStairs(int n) {
        return climbStairs2(n);
    }
    
    //递归
    public int climbStairs1(int n) {
        int r;
        if (n==1) return 1;
        else if (n==2) return 2;
        else return climbStairs1(n-1)+climbStairs1(n-2);
      
    }
    //递归+记忆法
    public int climbStairs2(int n) {
        int r; 
        //return r;
        if(temp ==null) temp = new int[n+1];
        if (n==1) return 1;
        else if (n==2) return 2;
        else if (temp[n]>0) return temp[n];
        else{
        	for (int i=3;i<n;i++){
        		temp[i]=climbStairs2(i);
        	}
        	//out.println();
        	return climbStairs2(n-1)+climbStairs2(n-2);
        }
     
    }
}
