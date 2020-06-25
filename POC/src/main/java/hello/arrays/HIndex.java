package com.company.arrays;

public class HIndex {

    public static void main(String[] args) {

        int nums[] = {10,20,30};
        int nums1[] = {0,1,3,5,6};
        int nums2[] = {100};

        System.out.println(hIndex(nums2));
        System.out.println(hIndex(nums1));
        System.out.println(hIndex(nums));

    }

    public static int hIndex(int[] citations) {

        if(citations.length == 0) return 0;
        int i = 0, n = citations.length;

        int mid, start = 0, end = n - 1;
        int res = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (citations[mid] == n - mid) return n - mid;
            else if (citations[mid] < n - mid) start = mid + 1;
            else{
                res = n - mid;
                end = mid - 1;
            }
        }

        return res;

    }
}
