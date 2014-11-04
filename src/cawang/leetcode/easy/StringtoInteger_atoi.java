package cawang.leetcode.easy;

public class StringtoInteger_atoi {
	 public int atoi(String str) {
		 return atoi_1(str);
	 }
	//if invalid, return 0
    public int atoi_1(String str) {
    	final int INVALIDSTR=0;
        int result=INVALIDSTR;
        int sign=1;
        int firstIdx=0;
        boolean finished=false; 
        //notice firstIdx<=str.length()-1!!
        while(firstIdx<=str.length()-1&&str.charAt(firstIdx)==' ')firstIdx++; //skip white space in front
       // LOOP:
        for(int i=firstIdx;i<str.length()&&!finished;i++){
            char c=str.charAt(i);
            switch(c){
	            case '-': 
	            	if(i==firstIdx) sign=-1;
	            	//else break; //don't forget sign
	            	else finished=true;
	            	break;
	            case '+': 
	            	if(i==firstIdx) sign=1;
	            	else finished=true;
	            	break;
	            case '.':
	            	finished=true;
	            	break;
	            case '0':
	            case '1':
	            case '2':
	            case '3':
	            case '4':
	            case '5':
	            case '6':
	            case '7':
	            case '8':
	            case '9':
	            	if(result==INVALIDSTR) result=0;
	            	//deal with overflow, don't forget *10
	            	if(!willOverflow(result, c-48)){
	            		//System.out.println("c-48: "+(c-48)+"; result: "+result+"; reminder: "+(Integer.MAX_VALUE-result));
	            		result*=10;
		            	result+=c-48;
	            	}
	            	else {
	            		result=sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
	            		//System.out.println("overflow: "+result);
	            		finished=true;
	            	}
	            	break;
	            default:
	            	finished=true; //don't forget!
	            	break;
            }
        }
      
        
        //in case of overflow: 2147483648->-2147483648, should be 2147483647
        //"-2147483649->" should be -2147483648, not 2147483647
        //if(result<0)return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE; //not enough for -11919730356x
        result*=sign;
        return result; 
    }
    //add is less than 10
	private boolean willOverflow(int x, int add){
		if(x==0)return false;
		int abs=Math.abs(x);
		if(abs>Math.pow(10,9)) return true;
		if(abs*10>Integer.MAX_VALUE) return true;
		if(x/abs==1&&add>Integer.MAX_VALUE-x*10)return true;
		if(x/abs==-1&&add<=1+Integer.MAX_VALUE-x*10) return true;
		return false;
	}
    public static void main(String[] args){
    	char a='1';
    	System.out.println(a+1);
    	StringtoInteger_atoi obj=new StringtoInteger_atoi();
    	String s1="  ";
    	String s2=" .";
    	String s3=" -123.1fff";
    	String s4=" +12-3.1fff";
    	String s5="2147483648";
    	String s6="-2147483649";
    	String s7="      -11919730356x";
    	String s8="  -0012a42";
    	String s9="    10522545459"; //2147483647
    	System.out.println("1: \""+s1+"\""+"; \""+obj.atoi(s1)+"\"");
    	System.out.println("2: \""+s2+"\""+"; \""+obj.atoi(s2)+"\"");
    	System.out.println("3: \""+s3+"\""+"; \""+obj.atoi(s3)+"\"");
    	System.out.println("4: \""+s4+"\""+"; \""+obj.atoi(s4)+"\"");
    	System.out.println("5: \""+s5+"\""+"; \""+obj.atoi(s5)+"\"");
    	System.out.println("6: \""+s6+"\""+"; \""+obj.atoi(s6)+"\"");
    	System.out.println("7: \""+s7+"\""+"; \""+obj.atoi(s7)+"\"");
    	System.out.println("8: \""+s8+"\""+"; \""+obj.atoi(s8)+"\"");
    	System.out.println("9: \""+s9+"\""+"; \""+obj.atoi(s9)+"\"");
    }
}
