/**
 * 
 */
package cawang.leetcode.easy;

/**
 * @author cawang
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result;
        int oldLength=digits.length;
        int newLength=oldLength+1;
        int plusIdx=0;
        for(int i=oldLength-1;i>=0;i--){
        	if(digits[i]!=9){
        		plusIdx=i;
        		newLength=oldLength;
        		break;
        	}
       		//plusIdx=0;
        	//newLength=oldLength+1;
        }
    	result=new int[newLength];
        for(int i=newLength-1;i>=0;i--){
        	if(i>plusIdx)
        		result[i]=0;
        	else{
        		int j=oldLength-(newLength-i);
        		if (j>=0)result[i]=digits[j]; //Not result[i]=digits[i], fill value from ending
        	}
        }
        result[plusIdx]+=1; //Not inside loop
        return result;
    }
}
