package cawang.leetcode.easy;

public class LongestCommonPrefix {
    /**
     * @param strs
     * @return
     * the worse case complexity for your code is O(nk). 
     * n is the number of strs, and k is the average length of each string. But your code is very concise and clean.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String common=strs[0];
        for(int i=1;i<strs.length&&common!=null;i++){
            if(strs[i]==null||strs[i].equals("")) return "";
            String str2=strs[i];
            common=_helper(common, str2);
         }
        return common;
            
    }
    
    // or don't use String common, but use a index in strs[0] to indicate the substring
    private String _helper(String str1, String str2){
        StringBuilder common=new StringBuilder("");
        for(int i=0;i<str1.length();i++){
            if(i>str2.length()-1) break;
            if(str1.charAt(i)!=str2.charAt(i)) break;
            common.append(str1.charAt(i));
        } 
        return common.toString();
    }
}
