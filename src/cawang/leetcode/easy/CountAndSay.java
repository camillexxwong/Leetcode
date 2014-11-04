/**
 * 
 */
package cawang.leetcode.easy;

/**
 * @author cawang
 *
 */
public class CountAndSay {
    public String countAndSay(int n) {
    	return countAndSay2_recursive(n);
    }
    
    public String countAndSay1_wrongunderstanding(int n) {
        String result="";
        //result+=1;
        if (n==1) return "1";
        char[] previous=countAndSay1_wrongunderstanding(n-1).toCharArray();
        for (int i=0;i<previous.length;i++){
        	if(i==previous.length-1) //Out of Index
    			result+="1"+previous[i];//Shouldn't be 1+p[i]
        	else if(previous[i]==previous[i+1]){
        		result+="2"+previous[i];
        		i++;
        	}
        	else{
        		result+="1"+previous[i];
        	}
        }       
        return result;
    }
    
    
    public String countAndSay2_recursive(int n) {
        String result="";
        if (n==1) return "1";
        char[] previous=countAndSay(n-1).toCharArray();
        int localCount=1;
        for (int i=0;i<previous.length;i++){
    		while(i<previous.length-1&&previous[i]==previous[i+1]){
        		i++;
        		localCount++;
    		}
    		result+=""+localCount+previous[i];
    		localCount=1;
        }       
        return result;
    }
    
    
    public String countAndSay3_nonrecursive(int n) {
        String result="1";
        for (int i=2;i<=n;i++){
        	result=getNext3(result);
        }
        return result;
    }
    private String getNext3(String previous){
    	StringBuilder result=new StringBuilder("");
        int localCount=1;
        for (int i=0;i<previous.length();i++){
    		while(i<previous.length()-1&&previous.charAt(i)==previous.charAt(i+1)){
        		i++;
        		localCount++;
    		}
    		result.append(""+localCount+previous.charAt(i));
    		localCount=1;
        }       
        return result.toString();
    }
}
