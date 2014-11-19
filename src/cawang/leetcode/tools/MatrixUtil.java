package cawang.leetcode.tools;

import java.util.HashSet;

public class MatrixUtil {
	/**
	 * from Searcha2DMatrix
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
	public static int[] addOffset(int i, int j, int offset, int rowLength, int columnLength) {
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
     * return whether a 2D array has duplicates elements
     * The Time Complexity for HasSet.add() is NlogN, maybe use Heap Sort inside
     * Do not add escape to set, will save time, otherwise TLE and wrong answer
     * 
     * Time: O(N)+O(NLogN), N=m*n
     * Space: O(N)
     * 
     * From: cawang.leetcode.easy.ValidSudoku
     * 
     * @param matrix
     * @return
     */
    public static boolean hasDuplicates(char[][] matrix, char escape, int starti, int startj, int endi,int endj){
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
     * 判断一维数组是否有重复元素
     * From: cawang.leetcode.easy.ValidSudoku
     * Not Tested
     * 
     * @param matrix
     * @param starti
     * @param endi
     * @return
     * 
     */
    public static boolean hasDuplicates(char[] matrix, int starti, int endi){
    	HashSet<Character> set = new HashSet<Character>();
    	int n=endi-starti+1;
    	for(int i=starti;i<endi+1;i++){
    			set.add(matrix[i]);
    	}
    	if(n!=set.size()) return true;
    	else return false;
    }
    
	/**
	 * 适用于数组中distinct元素小于等于32的情况
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
    	
    /**
     * convert string to matrix, only int
     * From: cawang.leetcode.easy.ValidSudoku 改编
     * Not Tested
     * 
     * @param s
     * @param m: row length
     * @param n: column length
     * @return
     */
    public static char[][] convertStringToMatrix(String s, int m, int n){
    	char[][] result=new char[n][m];
    	int count=0;
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if( c>='0'&&c<='9'){ //'0', not 0
    			result[count/m][count%m]=c;
    			count++;
    		}
    	}
    	return result;
    }
}
