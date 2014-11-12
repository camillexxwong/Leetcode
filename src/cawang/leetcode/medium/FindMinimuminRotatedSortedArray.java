package cawang.leetcode.medium;

/**
 * 
 * @author cawang
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	Find the minimum element.

	You may assume no duplicate exists in the array.

	Hide Tags Array Binary Search
	
	Solution unlocked

 *
 */
public class FindMinimuminRotatedSortedArray {
	/**
	 * 
	 * @param num
	 * @return
	 * 
	 * 二分查找
	 * 如果num[mid]<num[low]， 说明pivot在左侧，否则在右侧
	 * 注意high=mid而不是mid+1, 由于pivot是最小值，当前mid可能是min
	 * 当n(num[low]<=num[mid]<=num[high]) 时，找到pivot=num[low]
	 */
    public int findMin(int[] num) {
    	if(num==null||num.length==0) return -1;
        int low=0;
        int high=num.length-1;
        while(true){
        	int mid=low+(high-low)/2;
        	if(num[mid]<num[low]) high=mid; //not mid-1
        	else if(num[mid]>num[high]) low=mid+1;
        	else return num[low]; //if(num[low]<=num[mid]<=num[high]) 
        }
    }
}
