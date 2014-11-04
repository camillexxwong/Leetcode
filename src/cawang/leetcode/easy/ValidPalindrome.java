package cawang.leetcode.easy;

public class ValidPalindrome {
	//"1a2" -> false
    //alphanumeric 文字、数字
    public boolean isPalindrome(String s) {
        if (s==null||s.length()==0) return true;
        for(int i=0,j=s.length()-1;i<j;i++,j--){  //two pointers
        	//System.out.println("ij1: "+i+", "+j);
            while(!isChar(s.charAt(i))&&i<s.length()-1) i++; //notice &&i<s.length()-1; case ",." ->out of index
            while(!isChar(s.charAt(j))&&j>0) j--;
            //System.out.println("ij: "+i+", "+j);
            if(i>=j) return true; //notice: i>=j; case ",." ->true
            if(toUpperCase(s.charAt(i))!=toUpperCase(s.charAt(j))) return false; 
            
/*            if (c[i]!=c[j]&&'a'-'A'!=(int)Math.abs(c[i]-c[j])) 
                return false;*/ // another method to compare ignoring case
        }
        return true;
    }

	private boolean isChar(char c) {
		if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>=48&&c<='9')) return true; //add '' for 0 and 9, or use 48-57
		return false;
	}
	private char toUpperCase(char c) {
		if((c>='a'&&c<='z')) return c-=32;
		return c;
	}
	
	public static void main(String[] args){
		String s="a.";
		String s2=",.";
		String s3="1a2";
		ValidPalindrome obj=new ValidPalindrome();
		System.out.println(s+": "+obj.isPalindrome(s));
		System.out.println(s2+": "+obj.isPalindrome(s2));
		System.out.println(s3+": "+obj.isPalindrome(s3));
	}
}
