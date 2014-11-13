package cawang.leetcode.medium;

import java.util.Arrays;

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
    	sortColors_1_twoPasses(A);
    }
    
    /**
     * 
     * @param A
     * 方法1-交换法
     * 双指针，forward从前向后，backward从后向前
     *  反复调用sortTwoNums方法
     *  第一遍遍历：forward找到第一个不是0的点，backward找到第一个不是2的点，交换
     *  直到两指针相遇
     *  第一次遍历结束后，所有的0在所有的2左边，1混杂其中
     *  记录相遇点
     *  
     *  第二遍遍历： 分为两部分，分别排序相遇点的左侧与右侧
     *  forward继续向后，并与另一个指针（从后向前）配合使用，排序1和2
     *  backward同理
     *  
     *  类似的方法可用于数组中含有m个不同的数， 复杂度将为m*n
     *  当元素不重复时，退化为n^2
     *  
     *  元素大于3时，此方法需改进，一次遍历后，可以记录每次两个元素的个数，
     *  下次遍历在中间挪出空位，把中间元素交换到中间位置
     *  
     *  Time: O(n) (2*n)
     *  Space: O（1）
     *  
     * @See sortTwoNums
     */
    public void sortColors_1_twoPasses(int[] A) {
    	int[] meetIdx=sortTwoNums(A,0,A.length-1,new int[]{0,2});
    	//if(meetIdx==null) return;
    	sortTwoNums(A,0,meetIdx[1],new int[]{0,1});
    	sortTwoNums(A,meetIdx[0],A.length-1,new int[]{1,2});
    }

	private void swap(int[] array, int i, int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	
    /**
     * 
     * @param array
     * @param begin
     * @param end
     * @param nums
     * @return
     * 
     * 功能： 将数组array在[begin, end]范围内排序， 假定该范围只有两个不同的元素， 存于nums
     * 使用双指针移动交换法，forward找到第一个不是nums[0]的点，backward找到第一个不是nums[1]的点，交换
     *  直到两指针相遇
     * 排序后所有的nums[0]将排在nums[1]左边
     * 
     * Time: O(n)
     * Space: O(1)
     * 
     */
   	private int[] sortTwoNums(int[] array, int begin, int end, int[] nums){
		if(begin>end)return null; //can change to >=, need null check in caller
		int forward=begin;
    	int backward=end;
		int num1=nums[0];
		int num2=nums[1];
	   	while(true){
    		while(forward<=end&&array[forward]==num1)forward++; //==, not !=
    		while(backward>=0&&array[backward]==num2)backward--;
    		if(forward>=backward)break; //if no 0 in A, i will > A.length-1
    		swap(array,forward++,backward--); //must use ++,-- here
    	}
	   	return  new int[]{forward,backward};
	}
	
	public static void main(String[] args){
		SortColors obj=new SortColors();
		int[] array1=new int[]{2,1};
		int[] array2=new int[]{0,2,1,0,1,2,2,1,2,0,2};
		int[] array3=new int[]{0};
		obj.sortColors(array1);
		System.out.println("array1: "+Arrays.toString(array1));
		obj.sortColors(array2);
		System.out.println("array2: "+Arrays.toString(array2));
		obj.sortColors(array3);
		System.out.println("array3: "+Arrays.toString(array3));
	}
	
	//better solutions
	//https://oj.leetcode.com/discuss/1827/anyone-with-one-pass-and-constant-space-solution
	//elements [0, left] are 0s
	//elements (left, current] are 1s
	//elements (current.right] are 2s
/*	 class Solution {
		    public:
		        void sortColors(int A[], int n) {
		            int left = 0;
		            int right = n - 1;
		            int current = 0;

		            while (current <= right) {
		                if (A[current] == 0) {
		                    swap(A[current], A[left++]);
		                } else if (A[current] == 1) {
		                    current++;
		                } else {
		                    swap(A[current], A[right--]);
		                }
		                current = max(current, left);
		            }

		            return;
		        }
		    };*/
	
/*	I can describe it in this way: 
	- p is the input iterator, reads new values, 
	is as faster than others so no problems of reading values already overwritten. 
	- i counts the number of 0 found, and a the same time writes zeroes. 
	- j counts the number of 0 + 1 found, and at the same time writes 1. 
	- k counts the number of 0 + 1 + 2 found and at the same time writes 2.*/
/*    public void sortColors(int[] A) {


    int i=-1, j=-1, k=-1;

    for(int p = 0; p < A.length; p++)
    {
        if(A[p] == 0)
        {
            A[++k]=2;
            A[++j]=1;
            A[++i]=0;
        }
        else if (A[p] == 1)
        {
            A[++k]=2;
            A[++j]=1;

        }
        else if (A[p] == 2)
        {
            A[++k]=2;
        }
    }

}*/
}
