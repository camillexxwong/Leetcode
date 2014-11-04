package cawang.leetcode.easy;


import org.junit.Test;

public class AddBinary {
    public String addBinary(String a, String b) {
        int la=a.length();
        int lb=b.length();
        int ll=la>lb?la:lb;
        StringBuilder result=new StringBuilder("");
        int addIdx=-2; //not in loop
        for(int i=ll-1;i>=0;i--){
            int offseta=i-(ll-la); //notice, not ll-la+i
            int offsetb=i-(ll-lb);
            int add=(i==addIdx)?1:0;
            int temp1=(offseta>=0)?a.charAt(offseta)-48:0;//must -48
            int temp2=(offsetb>=0)?b.charAt(offsetb)-48:0;
            int tempsum=temp1+temp2+add;
            if(tempsum>1){
                addIdx=i-1;
                tempsum-=2; //not =0
            }
            result.insert(0,tempsum);
        }
        if(addIdx==-1)result.insert(0,"1");
        
        return result.toString();
    }
    
    @Test
    public  void test(){
    	System.out.println(addBinary("0","0"));
    	System.out.println(addBinary("1111","1111"));
    	System.out.println(addBinary("1","1111"));
    }
}
