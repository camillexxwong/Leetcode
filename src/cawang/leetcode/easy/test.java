package cawang.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class test {
	public static void main(String[] args){
		HashMap map=new HashMap();
		Set keys=map.keySet();
		Object[] keysarray=keys.toArray();
		
		int[] array={1,1,1,2,2};
		HashSet<Integer> set=new HashSet<Integer>();
		for(int a:array){
			set.add(a);
		}
		Object[] newarray=set.toArray();
		System.out.println(Arrays.toString(newarray));
		
		Integer[] newarray2=set.toArray(new Integer[]{});
		System.out.println(Arrays.toString(newarray2));
		
		Object[] objs=new Object[]{1,2};
		Integer[] ints=(Integer[]) objs;
		System.out.println(Arrays.toString(ints));
		
	}
}
