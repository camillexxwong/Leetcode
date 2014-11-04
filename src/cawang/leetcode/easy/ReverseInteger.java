package cawang.leetcode.easy;

public class ReverseInteger {
	 public static int reverse(int x) {
		 return reverse1(x);
	 }
    public static int reverse1(int x) {
       int r=0;
       int length=0;
       if (x==0)return 0;
//       if(x>1000000004)return 0;
       for(int i=1000000000;i>=1;i/=10){
    	   if(length==0&&Math.abs(x/i)>0) {
    		   length=i*(x/Math.abs(x));
    		   //System.out.println(x/Math.abs(x)+"    "+length);
    		       	   }
    	   
    	   r+=(Math.abs(x)/i)*(length/i);
    	   if(x!=0)x-=(Math.abs(x)/i)*(i)*(x/Math.abs(x));
    
       }
      // if(x<0) r=r*(-1);
       return r;
    }
}
