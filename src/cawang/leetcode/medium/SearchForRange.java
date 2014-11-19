package cawang.leetcode.medium;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).
	
	If the target is not found in the array, return [-1, -1].
	
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
	
	Hide Tags Array Binary Search

 * @author cawang_home
 *
 */
public class SearchForRange {
	/**
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] A, int target) {
        int[] range=new int[]{-1,-1};
        int low=0;
        int high=A.length-1;
        while(low<=high){
        	int mid=low+(high-low)/2;
        	if(A[mid]==target) {
        	    range[0]=range[1]=mid;
        	    break; //don't forget break
        	}
        	else if(A[mid]<target) low=mid+1;
        	else high=mid-1;
        }
        range[0]=high;
        range[1]=low;
        return range;
    }
}
