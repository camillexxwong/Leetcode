package cawang.leetcode.medium;

/**
 * 
 * @author cawang
 * Given an array of integers, every element appears three times except for one. Find that single one.

	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

	Hide Tags Bit Manipulation

 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		//return singleNumber_1_wrong(A);
		//return singleNumber_2(A);
		return singleNumber_3(A);
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 * 
	 * 方法：bit manipulation
	 * 设single number为x, 其他数的不重复加和为m
	 * sum1=A所有元素的和=3*m+x
	 * sum2=XOR后的和=m+x  -> this wrong, a xor b xor c=| |a-b|-c |， not a+b+c
	 * 则x=(3*sum2-sum1)/2
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 */
	public int singleNumber_1_wrong(int[] A) {
        int sum1_real=0; //real sum
        int sum2_xor=0; //xor sum
        for(int i=0;i<A.length;i++){
        	sum1_real+=A[i];
        	sum2_xor=sum2_xor^A[i]; //not +=, only=
        }
        return (3*sum2_xor-sum1_real)/2;
    }
	
	/**
	 * @See https://oj.leetcode.com/discuss/9763/accepted-proper-explaination-does-anyone-have-better-idea
	 * 
	 */
	private int singleNumber_2(int[] A) {
		int onces=0; //hold xor result of elements that only appears once so far
		int twices=0; //hold xor result of elements that only appears twice so far
		int thirds=0; //hold xor result of elements that only appears three times so far
		for (int a:A){
			twices=twices|(onces&a); //add elements that appears for the second time
			onces=onces^a; //if a appears for the second time, remove a from onces
			thirds=onces&twices; //thirds=common elements of onces and twices
			onces=onces&(~thirds); //remove thirds from onces;
			twices=twices&(~thirds); //remove thirds from twices;
		}
		return onces;
	}
	
	/**
	 * 余数法， 改变repeatTimes，同样适用于其他元素重复n次
	 * 余数一定是0或1
	 * @param A
	 * @return
	 * 想象A中的每个元素a都有32位，分别把所有元素的每一位（ith bit）加起来（bit, 二进制位），除以3求余
	 * 该余数就是single number在该位(ith)的值
	 * 
	 * Time: 32*n
	 * Space: O(1);
	 */
	private int singleNumber_3(int[] A){
		int repeatTimes=3; //can be any number
		int result=0;
		int i=0;
		while(i<32){
			int sum=0; //sum of the ith bit of all elements
			//notice the overflow, Math.pow(2, 31)=2^31-1
			int mask=i==31?Integer.MIN_VALUE:(int) Math.pow(2, i); //0001,0010,0100,...
			for(int a:A){
				System.out.println("  sum: "+sum);
				sum+=a&mask;
			}
			int remainder=(sum/mask)%repeatTimes; //remainder is the ith bit of result
			result+=remainder*mask;
			System.out.println("i: "+i+", result: "+result+", sum: "+sum+", remainder: "+remainder+", mask:"+mask);
			i++;
		}
		return result;
	}
	
	public static void main (String[] args){
		SingleNumberII obj=new SingleNumberII();
		int[] A1={1};
		int[] A2={2,2,3,2};
		int[] A3={-2,-2,3,-2};
		int[] A4={-2,-2,1,1,-3,1,-3,-3,-4,-2};
		//System.out.println(obj.singleNumber_3(A1));
		//System.out.println(obj.singleNumber_3(A2));
		System.out.println(obj.singleNumber_3(A3));
	}
}
