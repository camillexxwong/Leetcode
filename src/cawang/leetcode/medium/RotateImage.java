package cawang.leetcode.medium;

import java.util.Arrays;

/**
 * 
 * @author cawang
 *You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).
	
	Follow up:
	Could you do this in-place?
	
	Hide Tags Array

 */
public class RotateImage {
    public void rotate(int[][] matrix) {
    	//rotate_1_notInPlace(matrix);
    	rotate_2_inPlace(matrix);
    }
    
    /**
     * 
     * @param matrix
     * 
     * not in place method doesn't work, 
     * since the method cannot modify the reference of parameter outside method
     * This function is correct inside, not correct to its caller.
     * 
     * Time: O(n*n), n*n is the size of the 2-dim array
     * Space: O(n*n)
     */
    public void rotate_1_notInPlace(int[][] matrix) {
        int length=matrix.length;
        int[][] rotateMatrix=new int[length][length];
        for(int i=0;i<length;i++){
        	for(int j=0;j<length;j++){
        		rotateMatrix[j][length-1-i]=matrix[i][j];
        	}
        }
        matrix=rotateMatrix; //Doesn't work outside method!
        //System.out.println("inner: "+Arrays.deepToString(matrix));
    }
    

    
    /**
     * 
     * @param matrix
     * 
     * similar method as 1, but is in place,
     * use a temp to store target value, temp init value is [0,0]
     * put temp to target [j][length-1-i]
     * then set i,j=target position, temp=new [i,j]
     * 
     * This need 3 nested loops, 
     * loop1: stand for each level of round, [loop1,loop1] is the left-top start point of each level; stop when i==j==length/2 
     * loop2: in each round, i will be back to loop1(start point) after loop 4 times, 
     *  need to be set as +1 after each 4 times 
     *  stop when reach the end of the round -1, no need to change the last one (which is the right-top corner), already changed in round 1
     * loop3: loop 4 times - 4 directions
     * 
     * i,j is reset in each loop2, i start from loop1; j start from loop2
     * 
     * Sample:
     * array3, ori: [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
	    step 000 i: 0, j: 3; [[1, 2, 3, 1], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
	    step 001 i: 3, j: 3; [[1, 2, 3, 1], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 4]]
	    step 002 i: 3, j: 0; [[1, 2, 3, 1], [5, 6, 7, 8], [9, 10, 11, 12], [16, 14, 15, 4]]
	    step 003 i: 0, j: 0; [[13, 2, 3, 1], [5, 6, 7, 8], [9, 10, 11, 12], [16, 14, 15, 4]]
	    step 010 i: 0, j: 2; [[13, 2, 5, 1], [5, 6, 7, 8], [9, 10, 11, 12], [16, 14, 15, 4]]
	    step 011 i: 2, j: 3; [[13, 2, 5, 1], [5, 6, 7, 8], [9, 10, 11, 3], [16, 14, 15, 4]]
	    step 012 i: 3, j: 1; [[13, 2, 5, 1], [5, 6, 7, 8], [9, 10, 11, 3], [16, 12, 15, 4]]
	    step 013 i: 1, j: 0; [[13, 2, 5, 1], [14, 6, 7, 8], [9, 10, 11, 3], [16, 12, 15, 4]]
	    step 020 i: 0, j: 1; [[13, 9, 5, 1], [14, 6, 7, 8], [9, 10, 11, 3], [16, 12, 15, 4]]
	    step 021 i: 1, j: 3; [[13, 9, 5, 1], [14, 6, 7, 2], [9, 10, 11, 3], [16, 12, 15, 4]]
	    step 022 i: 3, j: 2; [[13, 9, 5, 1], [14, 6, 7, 2], [9, 10, 11, 3], [16, 12, 8, 4]]
	    step 023 i: 2, j: 0; [[13, 9, 5, 1], [14, 6, 7, 2], [15, 10, 11, 3], [16, 12, 8, 4]]
	    step 110 i: 1, j: 2; [[13, 9, 5, 1], [14, 6, 6, 2], [15, 10, 11, 3], [16, 12, 8, 4]]
	    step 111 i: 2, j: 2; [[13, 9, 5, 1], [14, 6, 6, 2], [15, 10, 7, 3], [16, 12, 8, 4]]
	    step 112 i: 2, j: 1; [[13, 9, 5, 1], [14, 6, 6, 2], [15, 11, 7, 3], [16, 12, 8, 4]]
	    step 113 i: 1, j: 1; [[13, 9, 5, 1], [14, 10, 6, 2], [15, 11, 7, 3], [16, 12, 8, 4]]
		array3, new, method2: [[13, 9, 5, 1], [14, 10, 6, 2], [15, 11, 7, 3], [16, 12, 8, 4]]

     * Each node will only be visted once
     * Time: O(n*n), n*n is the size of the 2-dim array
     * Space: O(1)
     */
    public void rotate_2_inPlace(int[][] matrix) {
    	int length=matrix.length;
    	for(int loop1=0;loop1<length/2;loop1++){ 
	        for(int loop2=loop1;loop2<length-loop1-1;loop2++){ 
	        	//System.out.println("   loop2: "+loop2+", loop1: "+loop1+", bound: "+(length-1-2*loop1));
	        	int i=loop2; //notice!!
	    		int j=loop1; //notice!!
	    		int temp=matrix[i][j];
	        	for(int loop3=0;loop3<4;loop3++){  
		        	int temp2=matrix[j][length-1-i];
		    		matrix[j][length-1-i]=temp;
		    		temp=temp2; // put temp to new location, put new location's value to temp
		    		int temp_i=i; //important!!
		    		i=j;
		    		j=length-1-temp_i;
		    		//System.out.println("    step "+loop1+loop2+loop3+" "+"i: "+i+", j: "+j+"; "+Arrays.deepToString(matrix));
	        	}
	        }
    	}
        //matrix[0][0]=temp;
    }
    
    /**
     * loop is not set correctly, after 4 times, pointer will be back to start point!
     * @param matrix
     */
    public void _rotate_2_inPlace_wrong(int[][] matrix) {
    	int length=matrix.length;
    	int loop=length*length;
    	int i=0;
    	int j=0;
    	int temp=matrix[i][j];
        while(loop>0){
        	int temp2=matrix[j][length-1-i];
    		matrix[j][length-1-i]=temp;
    		temp=temp2; // put temp to new location, put new location's value to temp
    		int temp_i=i; //important!!
    		i=j;
    		j=length-1-temp_i;
    		loop--;
    		System.out.println("    step"+loop+" "+"i: "+i+", j: "+j+"; "+Arrays.deepToString(matrix));

        }
        //matrix[0][0]=temp;
    }

    
    public static void main(String[] args){
    	RotateImage obj=new RotateImage();
    	int[][] array1=new int[][]{{1,2},{3,4}};
    	int[][] array2=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    	int[][] array3=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	System.out.println("array1, ori: "+Arrays.deepToString(array1));
    	obj.rotate_1_notInPlace(array1);
    	System.out.println("array1, new, method1: "+Arrays.deepToString(array1));
    	obj.rotate_2_inPlace(array1);
    	System.out.println("array1, new, method2: "+Arrays.deepToString(array1));
    	
    	System.out.println("array2, ori: "+Arrays.deepToString(array1));
    	obj.rotate_2_inPlace(array2);
    	System.out.println("array2, new, method2: "+Arrays.deepToString(array2));
    	
    	System.out.println("array3, ori: "+Arrays.deepToString(array3));
    	obj.rotate_2_inPlace(array3);
    	System.out.println("array3, new, method2: "+Arrays.deepToString(array3));
    }
}
