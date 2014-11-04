package cawang.leetcode.easy;

import java.util.List;
import java.util.Stack;

public class PascalsTriangleII {
    //AC at the first time
    //Use another local variable Stack currentLine, currentLine.size()<=k
    public List<Integer> getRow(int rowIndex) {
    	Stack<Integer> result=new Stack<Integer>();
        result.push(1);
        for(int i=1;i<=rowIndex;i++){
        	Stack<Integer> currentLine=new Stack<Integer>();
            currentLine.push(Integer.valueOf(1));
            while(result.size()>=2){
                currentLine.push(result.pop()+result.peek());
            }
            currentLine.push(Integer.valueOf(1));
            result=currentLine;
        }
        return result;
    }
}
