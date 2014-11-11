package cawang.leetcode.easy;

import java.util.Arrays;

public class MinStack {
	private int[] elementData;
    private int size;
    private int capacity;
    private int min;
    //private int secondMin;
    
    public MinStack(){
        elementData=new int[100];
        size=0;
        capacity=100;
    }
    
    public void push(int x) {
        if(size==0)  min=x;    //!!!!
        if(size==capacity){
            capacity=capacity<<1;
            elementData=Arrays.copyOf(elementData, capacity);
        }
        elementData[size++]=x;
        if(x<min) {   //!!!!
            //secondMin=min;
            min=x; 
        }
    }

    public void pop() {
        
        if(top()==min){
            int lmin=elementData[0];
            for(int i=0;i<size-1;i++){
                if(elementData[i]<lmin) lmin=elementData[i];
            }
            min=lmin;
        }
        size--;
        
    }

    public int top() {
        return elementData[size-1];
    }

    public int getMin() {
        /*int min=0;
        for (int i=0;i<size;i++){
            if(elementData[i]<elementData[min]) min=i;
        }
        return elementData[min];*/
        return min;
    }
}
