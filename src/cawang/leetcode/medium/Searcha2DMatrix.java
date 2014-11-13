package cawang.leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author cawang
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
	
	Hide Tags Array Binary Search

 */
	
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
		//return searchMatrix_1(matrix,target);
		//return searchMatrix_2(matrix,target);
    	return searchMatrix_3(matrix,target);
    }

    /**
     * not complete, try to calculate the mid directly
     * not correct so far
     * @param matrix
     * @param target
     * @return
     */
	public boolean _searchMatrix_1_notcomplete(int[][] matrix, int target) {
		int m=matrix[0].length; //row length
		int n=matrix.length; //column length
		int low_i=0, low_j=0;
		int high_i=n-1, high_j=m-1;
		while(!(low_i>=high_i&&low_j>=high_j)){
			System.out.println("low: "+low_i+", "+low_j+"; high: "+high_i+", "+high_j);
			int mid_i=low_i+(high_i-low_i)/2;
			int mid_j=(low_j+((high_j-low_j+4)%4)/2)%4; 
			System.out.println("mid: "+mid_i+", "+mid_j);
			if(target==matrix[mid_i][mid_j]) return true;
			else if(target>matrix[mid_i][mid_j]){
				low_i=mid_i+(mid_j+1)/4;
				low_j=(mid_j+1)%4;
			}
			else{
				high_i=mid_i+(mid_j-1)>0?0:-1;;
				high_j=(mid_j-1+4)%4;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 
	 * same as binary search, just change the mid calculation, low+1, and high-1 to 2D calculation
	 * use addOffset() as helper
	 * 
	 * Key: addOffset() method
	 * 
	 * @See cawang.leetcode.Search2DMatrix.addOffset()
	 */
	public boolean searchMatrix_2(int[][] matrix, int target) {
		int m=matrix[0].length; //row length
		int n=matrix.length; //column length
		int low_i=0, low_j=0;
		int high_i=n-1, high_j=m-1;
		while( low_i<high_i || (low_i==high_i && low_j<=high_j) ){ //not >=, not while(!(low_i>high_i||low_j>high_j))
			System.out.println("  loop  low: "+low_i+", "+low_j+"; high: "+high_i+", "+high_j);
			int length=m*(high_i-low_i)+(high_j-low_j)+1;
			int offset=(length-1)/2;
			int[] mid=addOffset(low_i,low_j,offset,m,n);
			int mid_i=mid[0];
			int mid_j=mid[1]; 
			System.out.println("        mid: "+mid_i+", "+mid_j);
			if(target==matrix[mid_i][mid_j]) return true;
			else if(target>matrix[mid_i][mid_j]){
				System.out.println("        low=mid+1");
				int[] low=addOffset(mid_i,mid_j,1,m,n);
				low_i=low[0];
				low_j=low[1];
			}
			else{
				System.out.println("        high=mid-1");
				int[] high=addOffset(mid_i,mid_j,-1,m,n);
				high_i=high[0];
				high_j=high[1];
			}
			System.out.println("        After, low: "+low_i+", "+low_j+"; high: "+high_i+", "+high_j);
		}
		return false;
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @param offset
	 * @param rowLength
	 * @param columnLength
	 * @return
	 * 
	 * a helper of method 2
	 * given a [i ,j] in 2D array, calculate the new [i, j] adding offset
	 */
	private int[] addOffset(int i, int j, int offset, int rowLength, int columnLength) {
		int[] result=new int[2];
		int m=rowLength;
		int new_i;
		int new_j;
		if(offset>0){
			new_i=i + offset/m + ((j+offset%m)>(m-1)?1:0); //need bracket, +- has higher priority than >《
			new_j=j + offset%m - ((j+offset%m)>(m-1)?m:0);
		}
		else if(offset<0){
			offset*=-1;
			new_i=i - offset/m - ((j-offset%m)<0?1:0);
			new_j=j - offset%m + ((j-offset%m)<0?m:0);
		}
		else{
			new_i=i;
			new_j=j;
		}
		System.out.println("             new_i: "+new_i+", new_j: "+new_j);
		result[0]=new_i;
		result[1]=new_j;
		return result;
	}

	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 * 
	 * better solution
	 * treat the 2D matrix as 1D array
	 * just transfer mid to mid_i and mid_j inside loop
	 * Key:
	  		int mid_i=mid/m;
			int mid_j=mid%m;
			
	 * Other parts are same bibary search
	 */
	public boolean searchMatrix_3(int[][] matrix, int target) {
		int m=matrix[0].length; //row length
		int n=matrix.length; //column length
		int low=0;
		int high=m*n-1;
		while( low<=high){ //not >=, not while(!(low_i>high_i||low_j>high_j))
			int mid=low+(high-low)/2;
			int mid_i=mid/m;
			int mid_j=mid%m;
			if(target==matrix[mid_i][mid_j]) return true;
			else if(target>matrix[mid_i][mid_j]){
				low=mid+1;
			}
			else{
				high=mid-1;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		//System.out.println(-1/4);
		Searcha2DMatrix obj=new Searcha2DMatrix();
		int[][] array1={{1,1}};
		int val1=2;
		System.out.println("Array1: "+Arrays.deepToString(array1));
		//System.out.println(obj.searchMatrix_1(array1, val1));
		System.out.println(obj.searchMatrix_2(array1, val1));
		
		int[][] array2={{0,1,2},{3,4,5}};
		int val2=5;
		System.out.println("Array2: "+Arrays.deepToString(array2)+", target: "+val2);
		//System.out.println(obj.searchMatrix_1(array2, val2));
		System.out.println(obj.searchMatrix_2(array2, val2));
		
		System.out.println("Array2: "+Arrays.deepToString(array2)+", target: "+6);
		System.out.println(obj.searchMatrix_2(array2, 6));
		
		System.out.println("Array2: "+Arrays.deepToString(array2)+", target: "+2);
		System.out.println(obj.searchMatrix_2(array2, 2));
		
		int[][] array3={{0,1,2,3},{4,5,6,7},{8,9,10,11}};
		int val3=3;
		System.out.println("Array3: "+Arrays.deepToString(array3)+", target: "+val3);
		System.out.println(obj.searchMatrix_2(array3, val3));
		
	}
}
