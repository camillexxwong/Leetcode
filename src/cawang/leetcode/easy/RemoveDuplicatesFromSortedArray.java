package cawang.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        Queue<Integer> q=new LinkedList<Integer>();
        int count=0;
        int step=1;
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]) {
            	q.add(i);
            	count++;
            }
        }
        while(!q.isEmpty()){
            int begin=q.poll().intValue();
            int end;
            if(!q.isEmpty())     end=q.peek().intValue();
            else  end=A.length;
            for(int j=begin+1;j<end;j++){
                A[j-step]=A[j];
            }
            step++;
        }
        int newLength=A.length-count;
/*        for(int k=newLength;k<A.length;k++){
        	A[k]==null;
        }*/
        return newLength;
    }
    
    @Test
    public void test(){
    	int[] A1={1,2};
    	removeDuplicates(A1);
    	System.out.println(Arrays.toString(A1));
    	
    	int[] A2={1,1,1,2};
    	removeDuplicates(A2);
    	System.out.println(Arrays.toString(A2));
    }
    
}
