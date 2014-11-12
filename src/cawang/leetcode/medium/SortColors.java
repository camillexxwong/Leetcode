package cawang.leetcode.medium;
/**
 * 
 * @author cawang
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	
	Note:
	You are not suppose to use the library's sort function for this problem.
	
	click to show follow up.
	
	Follow up:
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
	
	Could you come up with an one-pass algorithm using only constant space?
	Hide Tags Array Two Pointers Sort

 *
 */
public class SortColors {
    public void sortColors(int[] A) {
    	int i=-1;
    	int j=A.length;
    	while(true){
    		while(A[++i]!=0)if(i==A.length-1)break;
    		while(A[--j]!=2)if(j==0)break;
    		if(i>=j)break; //if no 0 in A, i will > A.length-1
    		swap(A,i,j);
    	}
    	int meeti=i;
    	int meetj=j;
    	while(i>=0){
    		while(A[i]!=2)swap(A,i,meetj++);
    		i--;
    		while(A[j]!=0)swap(A,j,meeti--);
    	}
    }

	private void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
    
}
