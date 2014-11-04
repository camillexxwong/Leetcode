package cawang.leetcode.easy;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A==null)return 0;
    	int newLength=A.length;
        for(int i=0,j=A.length-1;i<A.length&&j>=i;i++){
        	if(A[i]==elem){
        		newLength-=1;
        		while(A[j]==elem&&j>i){
            		newLength-=1;
        			j--;
        		}
         			A[i]=A[j--];
        	}
        	
        }
	    int[] B=new int[newLength];
	    for(int i=0;i<B.length;i++){
	    	B[i]=A[i];
	    }
	    A=B;
        return newLength;
    }
    
    public int removeElement_getLengthOnly(int[] A, int elem) {
    	if (A == null)	return 0;
		int newLength = A.length;
		for (int a : A) {
			if (elem == a)	newLength -= 1;
		}
		return newLength;
	}
}
