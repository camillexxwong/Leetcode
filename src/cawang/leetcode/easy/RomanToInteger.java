/**
 * 
 */
package cawang.leetcode.easy;

/**
 * @author cawang
 *
 */
public class RomanToInteger {
	//suppose s is valid
    public int romanToInt(String s) {
    	int result=0;
    	int length=s.length();
    	for(int i=0;i<length;i++){
    		if(s.charAt(i)=='M'){
    			result+=1000;
    		}
    		else if(s.charAt(i)=='M'){}
    	}
    	return result;
    }
}
