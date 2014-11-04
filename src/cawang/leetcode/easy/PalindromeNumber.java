package cawang.leetcode.easy;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        //return isPalindrome_1(x);
        return isPalindrome_2(x);
    }
    //TLE for 1854774581
    public boolean isPalindrome_1(int x) {
        if(x<0) return false; //-1 -> false
        if(x==0) return true;
        int length =10;
        int max=(int) Math.pow(10,9);
        while(x/max==0){ //&&max>=1
            length--;
            max/=10;
        }
        int low2=0;
        int high2=0;
        for(int i=0;i<length/2;i++){  //if length is odd, length/2 is the middle number
            //if(i>=length-i) break; // or ==
            int high=(int) Math.pow(10,length-1-i);
            int low=(int) Math.pow(10,i);
            low2=i+1<=length-1?(int) Math.pow(10,i+1):0; //notice condition, 1 -> true
            System.out.println(high+", "+low+", "+low2);
            System.out.println((x-high2)/high+", "+(x/low-(x/low2)*low2));
            if((x-high2)/high!=x/low-(x/low2)*10) return false;
            //low2=(x/low)*low;
            high2=(x/high)*high;
        }
        return true;
    }
    
    //saw discuss for reference, use %10!! notice use temp instead of x
    //TLE for 2147483647
/*    But it turns out that overflow is automatically handled: 
    palindromeX will result in a negative number because of overflow, 
    and that makes it never equals to the input number x...*/
    public boolean isPalindrome_2(int x) {
        int reverse=0;
        int temp=x;
        while(temp>0){
            reverse*=10;
            reverse+=temp%10;
            temp/=10;
        }
        return reverse==x;
    }
        
        public static void main(String[] args){
        	PalindromeNumber obj=new PalindromeNumber();
        	 System.out.println(obj.isPalindrome(1001));
        	 
        	 System.out.println(obj.isPalindrome(1854774581));

        }
}
