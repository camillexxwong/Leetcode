package cawang.leetcode.medium;

import java.util.Arrays;

public class SingleNumber {
	//int result=0;
    public static int singleNumber(int[] A) {
        //return singleNumber2(A);
        //return singleNumber1(A);
        return singleNumber3(A);
        
    }
    
 //位运算
 public static int singleNumber1(int[] A){
      int result=0;
        for (int a:A){
            result=result^a;
        }
        return result;
 }
     
  public static int singleNumber2(int[] A){
	        int result=-1;
	        for (int i=0;i<A.length;i++){
	        	int k=0;
	            for (int j=0;j<A.length;j++){
	                if (i!=j&&A[i]==A[j]){
	                    k=1;
	                	break;
	                }
	            }
	            if(k!=1){
	            	return A[i];
	            }
	        }
	        return result;
	    }
	    
	  
  public static int singleNumber3(int[] A){
      Arrays.sort(A);
        boolean isFirstHit = true;
    int result = -1;
    for (int i = 0; i < A.length; i++) {
        if (isFirstHit) {
            result = A[i];
            isFirstHit = false;
        } else {
            if (result == A[i])
                isFirstHit = true;
            else
                break;
        }
    }
    
    return result;
}
}
