package cawang.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * @author cawang_home
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	
	
	A partially filled sudoku which is valid.
	
	Note:
	A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
	
	Hide Tags Hash Table

 *
 */
public class ValidSudoku {
	
	 public boolean isValidSudoku(char[][] board) {
		 return (isValidSudoku_1(board));
		 //return (isValidSudoku_2(board));
	 }
	/**
	 * 
	 * @param board
	 * @return
	 * 
	 * N=m*n
	 * 直观法，分别判断每行、每列、每个3*3小格是否有重复元素 （Time: 3*N)
	 * 借助辅助函数hasDuplicates(), 判断（二维）数组从起始点到终止点是否有重复元素
	 * 
	 * @See cawang.leetcode.easy.ValidSudoku.hasDuplicates(char[][], int, int, int, int)
	 * @See cawang.leetcode.easy.ValidSudoku.hasDuplicates(char[], int, int)
	 * 
	 * 总体复杂度(maybe)
	 * Time: m*(n+nlogn)+n*(m+mlogm)+9*(9+9log9), m=n=9, 3*n^2*(1+logn)
	 * O(N*logn)
	 * Space: max(m,n,9), O(n) (HashSet is local variable of hasDuplicates())
	 * 
	 */
    public boolean isValidSudoku_1(char[][] board) {
    	int m=board[0].length; //row length
    	int n=board.length;
    	char escape='.';
    	for(int i=0;i<n;i++){
    		//if(hasDuplicates(board[i],0,m-1)) return false;
    		if(hasDuplicates(board,escape, i,0,i,m-1)) {
    			//System.out.println("i: "+i);
    			return false;
    		}
    	}
    	for (int j=0;j<m;j++){
    		if(hasDuplicates(board,escape,0,j,n-1,j)) {
    		//	System.out.println("j: "+j);
    			return false;
    		}
    	}
    	for(int i=0;i<n;i+=3){
    		for(int j=0;j<m;j+=3){
    			if(hasDuplicates(board,escape,i,j,i+2,j+2)) {
    			//	System.out.println("i: "+i+", j:"+j);
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * return whether a 2D array has duplicates elements
     * The Time Complexity for HasSet.add() is NlogN, maybe use Heap Sort inside
     * Do not add escape to set, will save time, otherwise TLE and wrong answer
     * 
     * Time: O(N)+O(NLogN), N=m*n
     * Space: O(N)
     * 
     * @param matrix
     * @return
     */
    private  boolean hasDuplicates(char[][] matrix, char escape, int starti, int startj, int endi,int endj){
    	//System.out.println("!"+starti+startj+endi+endj);
    	HashSet<Character> set = new HashSet<Character>();
    	int m=endj-startj+1; //row length
    	int n=endi-starti+1;
    	int validNums=m*n;
    	for(int i=starti;i<endi+1;i++){ //not <n
    		for(int j=startj;j<endj+1;j++){
    			//System.out.println("ij: "+i+" "+j);
    			char c=matrix[i][j];
    			//System.out.println(c==escape);
    			if(c==escape)validNums--;
    			else set.add(c);
    		}
    	}
    	if(validNums!=set.size()) {
    		//System.out.println("size: "+set.size()+", nums: "+validNums);
    		return true;
    	}
    	else return false;
    }
    
    /**
     * 
     * @param matrix
     * @param starti
     * @param endi
     * @return
     * 判断一维数组是否有重复元素
     */
    private  boolean hasDuplicates(char[] matrix, int starti, int endi){
    	HashSet<Character> set = new HashSet<Character>();
    	int n=endi-starti+1;
    	for(int i=starti;i<endi+1;i++){
    			set.add(matrix[i]);
    	}
    	if(n!=set.size()) return true;
    	else return false;
    }
    
    /**
     * for testing, convert test case on Leetcode to Object
     * @param s
     * @return
     */
    private char[][] convertStringToMatrix(String s){
    	char[][] result=new char[9][9];
    	int count=0;
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if( (c>='0'&&c<='9')||c=='.'){ //'0', not 0
    			result[count/9][count%9]=c;
    			count++;
    		}
    	}
    	return result;
    }
    public static void main(String[] args){
    	ValidSudoku obj=new ValidSudoku();
    	//s1 is false
    	//s2 is true
        //s3 is false
    	String s1="[\"..5.....6\",\"....14...\",\".........\",\".....92..\",\"5....2...\",\".......3.\",\"...54....\",\"3.....42.\",\"...27.6..\"]";
    	String s2="[\".87654321\",\"2........\",\"3........\",\"4........\",\"5........\",\"6........\",\"7........\",\"8........\",\"9........\"]";
    	String s3="[\"..4...63.\",\".........\",\"5......9.\",\"...56....\",\"4.3.....1\",\"...7.....\",\"...5.....\",\".........\",\".........\"]";
    	char[][] test1=obj.convertStringToMatrix(s1);
    	char[][] test2=obj.convertStringToMatrix(s2);
    	
    	System.out.println(Arrays.deepToString(test1));
    	System.out.println(obj.isValidSudoku(test1));
    	
    	System.out.println(Arrays.deepToString(test2));
    	System.out.println(obj.isValidSudoku(test2));
    }
    
    /**
     * ToDo, use bitmask instead of hashset
     * @param board
     * @return
     */
    public boolean isValidSudoku_2(char[][] board){
    	return false;
    }
}
