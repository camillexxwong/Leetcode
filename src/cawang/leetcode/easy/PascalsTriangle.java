/**
 * 
 */
package cawang.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cawang
 *
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
    	//Inheritage in Generic Type
        //List<List<Integer>> result=new ArrayList<ArrayList<Integer>>(numRows);
    	//if (numRows<0) return null; //Don't forget!
    	if (numRows<=0) return new ArrayList<List<Integer>>(0); //Don't forget!
        List<List<Integer>> result=new ArrayList<List<Integer>>(numRows);
        List<Integer> first=new ArrayList<Integer>(1);
        first.add(1);
        result.add(first);
        for (int i=1;i<numRows;i++){
        	List<Integer> innerResult=new ArrayList<Integer>(numRows);
        	innerResult.add(1);
        	for(int j=1;j<i;j++){ //Not j<numRos-1
        		innerResult.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
        	}
        	innerResult.add(1);
        	result.add(innerResult);
        }
        return result;
    }
}
