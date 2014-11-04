package cawang.leetcode.easy;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        //return convert_1(s, nRows);
        return convert_2(s, nRows);
     }
     
     //Time: nRows*string.length
     //Space: string.length
     //correct answer at first time
     //TLE for (very long string, 4)
     private String convert_1(String s, int nRows) {
         if(nRows<=0) return "";
         if(nRows==1) return s;
         int k=nRows-2;
         int length=s.length();
         StringBuilder result=new StringBuilder("");
         for(int i=0;i<nRows;i++){
             int index=0;
             while(index<length){
                 if(index%(nRows+k)==i||index%(nRows+k)==(nRows+k-i)){
                     result.append(s.charAt(index));
                     //index+=nRows+k;
                 }
                index++;
             }
         }
         return result.toString();
     }
     
     //Time: string.length
     //Space: string.length
     //I think this should be the fasted solution!
     private String convert_2(String s, int nRows) {
         if(nRows<=0) return "";
         if(nRows==1) return s;
         int k=nRows-2;
         int length=s.length();
         StringBuilder result=new StringBuilder("");
         for(int i=0;i<nRows;i++){
             int index=i;
             while(index<length){  //index move faster, hit rate is 100%
                 result.append(s.charAt(index));
                 index+=(index%(nRows+k)==i)&&(i!=nRows-1)?nRows+k-2*i:2*i; //&&(i!=nRows-1), otherwise infinite loop; nRows+k-2*i+2*i=n+k
             }
         }
         return result.toString();
     }
}
