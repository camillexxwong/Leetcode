package cawang.leetcode.easy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Num: 46
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
		 //return (isValidSudoku_1(board));
		 try {
			return (isValidSudoku_2_bitMask(board));
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
    	//check row
    	for(int i=0;i<n;i++){
    		//if(hasDuplicates(board[i],0,m-1)) return false;
    		if(hasDuplicates(board,escape, i,0,i,m-1)) {
    			//System.out.println("i: "+i);
    			return false;
    		}
    	}
    	//check column
    	for (int j=0;j<m;j++){
    		if(hasDuplicates(board,escape,0,j,n-1,j)) {
    		//	System.out.println("j: "+j);
    			return false;
    		}
    	}
    	//check square
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
	 * same as method1, just call differnt hasDuplicates method
	 * @param board
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public boolean isValidSudoku_2_bitMask(char[][] board) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return isValidSudoku_template(board, "hasDuplicates_bitMask");
	}
	/**
     * Use bitmask instead of hashset
     * Time: O(n), 仅遍历一次，优于HashSet方法
     * @param board
     * @return
     * 
     * use bitmask instead of hashset
     * for each group (9 cells), set a groupbitmask, for each cell, set a cellbitmask
     * 
     * the bitmask will have a length of 9, 
     * 000000001 means there's one 1, and no others
     * 000001101 means there's one 1, one 3, one 4, and no others
     * 
     * groupbitmask stores the appeared elements in this group so far
     * cellbitmask stores the current element
     * if current already in gourp, groupbitmask&cellbitmask!=0
     * 每次循环即将结束时，更新groupbitmask, 加入当前的cell
     * groupbitmask=groupbitmask|cellbitmask
     * 
     * hint:
     * https://oj.leetcode.com/discuss/13929/o-n-2-java-solution-with-bitmasks
     *  for (int j = 0; j < SIZE; ++j) {
                char cell = board[i][j];
                if (cell == '.')
                    continue;
                int cellBitmask = 1 << (cell - '1');
                if ((cellBitmask & bitmask) != 0)
                    return false;
                bitmask |= cellBitmask;
            }
     */
    private  boolean hasDuplicates_bitMask(char[][] matrix, char escape, int starti, int startj, int endi,int endj){
    	int m=endj-startj+1; //row length
    	int n=endi-starti+1;
    	int validNums=m*n;
    	int groupBitMask=0;
    	for(int i=starti;i<endi+1;i++){ //not <n
    		for(int j=startj;j<endj+1;j++){
    			char c=matrix[i][j];
    			if(c==escape) continue; //!!
    			int cellBitMask=1<<(c-'1');
    			if((cellBitMask&groupBitMask)!=0)return true;
    			groupBitMask|=cellBitMask;
    		}
    	}
    	
    	return false;
    }
    
    private boolean isValidSudoku_template(char[][] board, String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, SecurityException{
       	//get method first, use invoke later
    	Class c_matrix=(new char[0][0]).getClass();
    	//Class c_char=Class.forName("java.lang.Character");
       	Class c_char=char.class;
    	Class c_int=int.class;
    	Class[] params=new Class[]{c_matrix,c_char,c_int,c_int,c_int,c_int};
    	Method method=this.getClass().getDeclaredMethod(methodName, params); //private method should use getDeclaredMethod, not getMethod
    	
    	int m=board[0].length; //row length
    	int n=board.length;
    	char escape='.';
    	//check row
    	for(int i=0;i<n;i++){
    		if((boolean) method.invoke(this,board,escape, i,0,i,m-1)) return false;
    	}
    	//check column
    	for (int j=0;j<m;j++){
    		if(hasDuplicates(board,escape,0,j,n-1,j)) return false;
    	}
    	//check square
    	for(int i=0;i<n;i+=3){
    		for(int j=0;j<m;j+=3){
    			if(hasDuplicates(board,escape,i,j,i+2,j+2)) return false;
    		}
    	}
    	return true;
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
		System.out.println(obj.isValidSudoku_1(test1));
		
		try {
			System.out.println(obj.isValidSudoku_2_bitMask(test1));
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.deepToString(test2));
		System.out.println(obj.isValidSudoku_1(test2));
		try {
			System.out.println(obj.isValidSudoku_2_bitMask(test2));
		} catch (ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
