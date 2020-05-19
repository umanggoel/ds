package com.company.arrays;

public class NumArray {

    Integer[] stree ;
    int[] nums;
    public NumArray(int[] nums) {
        this.stree = new Integer[15];
        this.nums = nums;
        segmentTreeUtil(0,nums.length-1,0);
    }

    public int sumRange(int start, int end) {
        return sumRageFromStree(0,nums.length-1,start,end,0);
    }

    public int sumRageFromStree(int start, int end,int rangeStart, int rangeEnd, int pos) {

        if(start >=rangeStart && end <=rangeEnd) return stree[pos];
        if(start <= rangeEnd && end >= rangeStart) {

            int mid = (start + end) / 2;

            int sumLeft = sumRageFromStree(start, mid, rangeStart, rangeEnd, 2 * pos + 1);
            int sumright = sumRageFromStree(mid + 1, end, rangeStart, rangeEnd, 2 * pos + 2);

            return sumLeft + sumright;
        } else {
            return 0;
        }
    }

    private void segmentTreeUtil(int start, int end, int pos){
        if(start < end) return;
        if(start==end) {
            this.stree[pos] = this.nums[start];
            return;
        }

        int mid = (start+end)/2;

        segmentTreeUtil(start,mid,2*pos+1);
        segmentTreeUtil(mid+1,end,2*pos+2);

        this.stree[pos] = this.stree[2*pos+1]+this.stree[2*pos+2];

    }
}
