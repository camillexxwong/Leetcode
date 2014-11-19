package cawang.leetcode.tools;

import java.util.HashSet;

public class ArrayUtil {
	/**not in-place, and has difficulty in cast type
	 * from: Remove Duplicates from Sorted Array
	 * @param A
	 * @return
	 */
    public int[] removeDuplicates_2(int[] array) {
    	HashSet<Integer> set =new HashSet<Integer>();
    	for(int a:array){
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
}
