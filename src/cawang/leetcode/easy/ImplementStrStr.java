package cawang.leetcode.easy;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        //return strStr_1(haystack, needle);
        return strStr_2(haystack, needle);
        // return strStr_3_KMP(haystack, needle);
    }
    
    //AC, O(m*n)
    public int strStr_1(String haystack, String needle) {
        if(haystack==null||needle==null) return -1;
        if(haystack.length()==0&&needle.length()==0) return 0;
        outerloop:
        for(int i=0;i<haystack.length();i++){
            for(int j=0;j<needle.length();j++){ //i+j<haystack.length()
            	//System.out.println("i: "+i+"; j: "+j);
            	if(i+j>haystack.length()-1) return -1;
                if(haystack.charAt(i+j)!=needle.charAt(j))
                	continue outerloop;
            }
            return i;
        }
        return -1;
    }
    //AC, without lable, O(m*n)
    public int strStr_2(String haystack, String needle) {
    	  if(haystack==null||needle==null) return -1;
          if(haystack.length()==0&&needle.length()==0) return 0;
          int i=0,j=0;
          while(i<haystack.length()){
        	  //System.out.println("i: "+i+"; j: "+j);
        	  if(j>needle.length()-1) return i; //before next condition
        	  if(i+j>haystack.length()-1) return -1;
        	  if(haystack.charAt(i+j)!=needle.charAt(j)){
        		  i++;
        		  j=0;
        	  }
        	  else j++;
          }
          return -1;
    }
    
    public int strStr_3_KMP(String haystack, String needle) {
        return -1;
    }
    
    public static void main(String[] args){
    	ImplementStrStr obj=new ImplementStrStr();
    	System.out.println(obj.strStr_1("", ""));
    	System.out.println(obj.strStr_1("aaa", "aaaa"));
    	System.out.println(obj.strStr_1("aaabaaaa", "aaaa"));
    	System.out.println(obj.strStr_2("", ""));
    	System.out.println(obj.strStr_2("aaa", "aaaa"));
    	System.out.println(obj.strStr_2("aaabaaaa", "aaaa"));
    }
}
