package cawang.leetcode.medium;

/**
 * Num: 48
 * 
 * Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].
	
	Hide Tags Array Two Pointers

 * @author cawang_home
 *
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        //return removeDuplicates_1(A);
        return removeDuplicates_2(A);
    }
    /** 
     * Similar method as method 1 in Problem I
     * Time: n+ minimum swap
     * Space: n
     * 
     * Use 2 pointers, 
     * 		0-slow contains non-dups and dups=1 elements
     * 		fast just move forward
     * 
     * Use an extra obj to store the most recent duplicate nums 
     * 		that already appeared twice
     * 
     * If a duplicates appear for the first time, set it is recentDup
     * If more than 1 time, fast just move without copy it to ++slow, 
     *  which means delete this elements
     * 
     * 
     * @param A
     * @return
     */
    public int removeDuplicates_1(int[] A) {
    	if(A==null||A.length==0) return 0;
        int slow=0;
        int fast=1;
        Integer recentDup=null;
        for(;fast<A.length;fast++){
        	if(A[fast]!=A[slow]) A[++slow]=A[fast];
        	else if(recentDup==null||A[fast]!=recentDup){
        		A[++slow]=A[fast];
        		recentDup=A[fast];
        	}
        	else{}
        }
        return slow+1;
    }
    
    /** 
     * A general solution for allowing k duplicates to keep
     * Similar as method 1
     * Instead of using recentDup, just compare with slow and slow-1
     * fast start from 2
	 *   	for(;fast<A.length;fast++){
	        	if(A[fast]==A[slow]&&A[fast]!=A[slow--]) {}
	        	else A[++slow]=A[fast];
	        }
     * Improve: just compare with slow-1 is enough
     * 
     * 
     * @param A
     * @return
     */
    public int removeDuplicates_2(int[] A) {
    	if(A==null) return 0;
    	int k=1; //allow 1 Duplicates,  k=0 means all distinct
    	if(A.length-1<k) return A.length; //slow>last index of A
        int slow=k; //not from 0
        int fast=k+1; //start from 2
        for(;fast<A.length;fast++){
        	if(A[fast]!=A[slow-k]) A[++slow]=A[fast];
        	else{}
        }
        return slow+1;
    }
    
    
}
