package cawang.leetcode.tools;

public class TwoDMatric {
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
}
