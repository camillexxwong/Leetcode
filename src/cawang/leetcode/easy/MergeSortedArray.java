package cawang.leetcode.easy;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        for(int k=m+n-1;k>=0;k--){ //&&(i>=0||j>=0), not necessary, since k=m+n-1>=0 -> m+n>=1
            if(i<0) A[k]=B[j--];
            else if(j<0)    {}
            else if(A[i]<B[j]) A[k]=B[j--];
            else A[k]=A[i--];
        }
    }
}
