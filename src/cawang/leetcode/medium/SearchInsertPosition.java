package cawang.leetcode.medium;

/**
 * @author cawang
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.

	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0

Hide Tags Array Binary Search

 */

public class SearchInsertPosition {
	/**
	 * 
	 * @param A
	 * @param target
	 * @return
	 * 
	 * 二分查找，类似search_range()
	 * 普通的二分查找+return low即可，
	 * 当二分查找结束时，low的值就是插入点，
	 * 如果low<A.length, A[low]一定大于target, 此时high=low-1，A[high]一定小于target
	 * 如果low=A.length，target就是新的最大值
	 */
    public int searchInsert(int[] A, int target) {
    	if(A==null) return 0;
        int result=0;
        int low=0;
        int high=A.length-1;
        while(low<=high){
        	int mid=low+(high-low)/2;
        	if(A[mid]==target) return mid;
        	if(A[mid]<target) low=mid+1;
        	else high=mid-1;
        }
        return low; //always: A[low]>target
    }
}
