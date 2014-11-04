package cawang.leetcode.easy;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        //return lengthOfLastWord_1(s);
        return lengthOfLastWord_2(s);
    }
    
    //2 mistakes: ' ' and if(count!=0)
    public int lengthOfLastWord_1(String s) {
        int count=0;
        int count_lastbut1=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') {  //notice: ' ' instead of " "
                if(count!=0)count_lastbut1=count;  //add if(count!=0)
                count=0;
            }
            else count++;
        }
        return count==0?count_lastbut1:count;
    }
    
    //backwards
    public int lengthOfLastWord_2(String s) {
        int i=s.length()-1;  //not  int i=s.length()
        while(i>=0&&s.charAt(i)==' ')i--;
        int j=i;
        while(j>=0&&s.charAt(j)!=' ')j--;
        return i-j;
    }
}
