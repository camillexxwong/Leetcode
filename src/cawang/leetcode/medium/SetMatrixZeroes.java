package cawang.leetcode.medium;

/**
 * Num:47
 * @author cawang_home
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

	click to show follow up.
	
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
	
	Hide Tags Array

 */
public class SetMatrixZeroes {
	 public void setZeroes(int[][] matrix) {
		 setZeroes_1(matrix);
		 //setZeroes_2(matrix);
	 }
	/**
	 * 
	 *
	 * 
	 * In-place, two-pass, 2*m*n
	 * pass 1 (m+n+(m-1)*(n-1)): 
	 *  mark the 坐标 of each 0; 
	 * 	instead of store the mark in another matrix(m*n) or array(m+n),
	 * 	directly store it in current matrix, change the first cell of this row and column to 0
		  if(matrix[i][j]==0){
	                	matrix[i][0]=0;
	                	matrix[0][j]=0;
	                }
	    1)需要先遍历第一行和第一列,以便确定第一行和第一列是否有0， 以免被后续操作覆盖
	    2)接下来的遍历将略过第一行和第一列
	    
	 * pass 2 (<m+n, 只遍历需要替换的点): 
	 *  convert cells to 0
	 * 
	 * Time: O(m*n) （<2*m*n)
	 * Space: O(1)
	 * 
	 *  @See https://oj.leetcode.com/discuss/15997/any-shortest-o-1-space-solution
	 *  @param matrix
	 */
    public void setZeroes_1(int[][] matrix) {
    	int row1=-1; //store whether the 1st row contains 0
    	int col1=-1;
    	
    	//Pass1 (m*n)
    	//go through first row
    	for(int j=0;j<matrix[0].length;j++){
    		if(matrix[0][j]==0){
            	row1=0;
            	break;
            }
    	}
    	//go through first column
    	for(int i=0;i<matrix.length;i++){
    		if(matrix[i][0]==0){
            	col1=0;
            	break;
            }
    	}
    	//go through others, and store 0 mark in first row and first column
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                	matrix[i][0]=0;
                	matrix[0][j]=0;
                }
            }
        }
        
        //Pass2 (<m*n, 遍历所有将被置为0的点
        //set certain column to 0
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
            	for(int i=1;i<matrix.length;i++)	matrix[i][j]=0;
            }
        }
        
        //set certain row to 0
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
            	for(int j=1;j<matrix[0].length;j++) matrix[i][j]=0;
            }
        }
        
        //set first column to 0
        if(col1==0){
        	for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
        }
        
        //set first row to 0
        if(row1==0){
        	for(int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
        }
    }
    
    /**
     * same as method 1, make it neat
     * Key： 
     * 	Pass1不需额外遍历第一行，第一列的遍历放在每行遍历中
     * 	Pass2采用bottom-up
     * 
     * Pass1 (m*n)
    	go through others, and store 0 mark in first row and first column
    	need to check column 1 first, but doesn't need to check row1, because row1 is gone through first
     *
     * Pass2 =m*n, 遍历所有的点, 比方法1慢
        步骤与Pass1正好相反
        set certain column and row to 0
        Use bottom-up, will be simpler, since first row will be visited last
        
        a little slower that method 1
        
        @param matrix
     */
    public void setZeroes_2(int[][] matrix) {
    	int row1=-1; //store whether the 1st row contains 0
    	int col1=-1;
    	
    	
        for(int i=0;i<matrix.length;i++){
        	if(matrix[i][0]==0) col1=0; //set before others
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                	matrix[i][0]=0;
                	matrix[0][j]=0;
                }
            }
        }
        
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][0]==0||matrix[0][j]==0) 
                	matrix[i][j]=0;
                }
            if(col1==0)matrix[i][0]=0; //change after others
        }
    }
}
