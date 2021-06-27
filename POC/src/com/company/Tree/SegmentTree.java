package com.company.Tree;

public class SegmentTree {

    void constructSegmentTreeForMinRange(int arr[],Integer segTree[], int start, int end, int pos){

        if(start == end) {
            segTree[pos] = arr[start];
            return;
        }

        int mid = (start+end)/2;

        constructSegmentTreeForMinRange(arr,segTree,start,mid,2*pos+1);
        constructSegmentTreeForMinRange(arr,segTree,mid+1,end,2*pos+2);

        segTree[pos] = Math.min(segTree[2*pos+1],segTree[2*pos+2]);

    }

     public int searchRange(Integer segTree[], int start, int end, int pos, int rangeStart, int rangeEnd){

        if(start >=rangeStart && end <=rangeEnd) return segTree[pos];
        if(start < rangeStart || end > rangeEnd) return Integer.MAX_VALUE;

        int mid = (start+end)/2;

        return Math.min(searchRange(segTree,start,mid,2*pos+1,rangeStart,rangeEnd),
        searchRange(segTree,mid+1,end,2*pos+2,rangeStart,rangeEnd));
    }

}
