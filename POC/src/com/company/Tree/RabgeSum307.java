package com.company.Tree;

public class RabgeSum307 {

    public static void main(String[] args) {
        RabgeSum307 rabgeSum307= new RabgeSum307(new int[]{-1});
        rabgeSum307.sumRange(0,0);
    }

    int[] segTree;
    int[] nums;
    int len;

    void constructSegmentTree(int start, int end, int pos) {
        if (start == end) {
            segTree[pos] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        constructSegmentTree(start, mid, 2 * pos);
        constructSegmentTree(mid + 1, end, 2 * pos + 1);
        segTree[pos] = segTree[2 * pos] + segTree[2 * pos + 1];

    }

    public RabgeSum307(int[] nums) {
        this.segTree = new int[nums.length * nums.length+1];
        this.nums = nums;
        this.len = nums.length;
        constructSegmentTree(0, this.len - 1, 1);
    }

    public void update(int index, int val) {
        nums[index] = val;
        this.segTree = new int[nums.length * nums.length];
        constructSegmentTree(0, this.len - 1, 1);
    }

    public int sumRange(int left, int right) {
        return searchRange(0, nums.length - 1, 1, left, right);
    }

    public int searchRange(int start, int end, int pos, int rangeStart, int rangeEnd) {

        if (start >= rangeStart && end <= rangeEnd) return segTree[pos];
        if (start > rangeEnd || end < rangeStart) return 0;

        int mid = (start + end) / 2;

        return searchRange(start, mid, 2 * pos, rangeStart, rangeEnd) +
                searchRange(mid + 1, end, 2 * pos + 1, rangeStart, rangeEnd);
    }

}