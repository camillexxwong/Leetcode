package cawang.leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        //return isValid_1(s);
        return isValid_2(s);
    }
    
    //stack.empty()
    public boolean isValid_1(String s) {
        //char[][] parentheses=new char[][]{{'(', ')'}, {'{', '}'}, {'[', ']'}};
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else if(c==')'){
                if(stack.empty()||stack.pop()!='(') return false; //notice: stack.empty()
            }
            else if(c=='}'){
                if(stack.empty()||stack.pop()!='{') return false;
            }
            else if(c==']'){
                if(stack.empty()||stack.pop()!='[') return false;
            }
            else{}
        }
        return stack.empty();
    }
    
    //use map
    //or use'(' as key, when met '(', push its pair, when pop, only compare equals
    public boolean isValid_2(String s) {
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        map.put(')', '(' );
        map.put('}', '{');
        map.put(']', '[' );
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsValue(c)){
                stack.push(c);
            }
            else if(map.containsKey(c)){
                if(stack.empty()||stack.pop()!=map.get(c)) return false;
            }
        }
        return stack.empty();
    }
}
