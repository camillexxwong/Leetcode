package cawang.leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] A) {
		//return removeDuplicates_1(A);
		//return removeDuplicates_2(A);
		return removeDuplicates_3(A);
	}



	/**
	 * Time: O(n)
	 * Space: O(n)
	 * Swap: minimum
	 * 
	 * 也可增加swap次数减少space
	 * @param A
	 * @return
	 */
	public int removeDuplicates_1(int[] A) {
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
    
	//not in-place, and has difficulty in cast type
    public int[] removeDuplicates_2(int[] A) {
    	HashSet<Integer> set =new HashSet<Integer>();
    	for(int a:A){
    		set.add(a);
    	}
    	Integer[] newArray=(Integer[]) set.toArray();
    	return parseIntegersToInts(newArray);
	}
    
    private int[] parseIntegersToInts(Integer[] array){
    	int[] result=new int[array.length];
    	for(int i=0;i<array.length;i++){
    		result[i]=array[i];
    	}
    	return result;
    }
    
    /**
     * Better solution, use 2 pointers, but same direction
     * Time: n
     * swap: minimum
     * Space: O(1)
     * 
     * @param a
     * @return
     */
	public int removeDuplicates_3(int[] A) {
		if(A==null||A.length==0) return 0;
		int slow=0; //pointer slow, as comparison
		int fast=1; //pointer fast
		while(fast<A.length){
			if(A[fast]!=A[slow]) A[++slow]=A[fast++]; //not slow++
			else fast++;
		}
		return slow+1;
	}
    @Test
    public void test(){
    	int[] A1={1,2};
    	removeDuplicates(A1);
    	System.out.println(Arrays.toString(A1));
    	
    	int[] A2={1,1,1,2};
    	removeDuplicates(A2);
    	System.out.println(Arrays.toString(A2));
    	
    	int[] A3={1,1,1,2,3,3,4};
    	System.out.println("length: "+removeDuplicates_3(A3)+", Array: "+Arrays.toString(A3));
    }
    
}
