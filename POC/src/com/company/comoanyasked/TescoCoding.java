package com.company.comoanyasked;

//Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues.
//
//In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:
//
//        In Bakery department: From 8 to 10
//        In Checkout department: From 10 to 12
//        In Diary department: From 14 to 19
//
//        Write a program to get the colleague’s shift timings for the day after
//        merging contiguous shifts. His shift timings in this case
//        are 8 to 12 and 14 to 19.

// int[][] arr = {{8,10}, {10, 12}, {14,19}}
//{{8,9}, {10, 12},{14,19}}
//{{2,9}, {7, 12},{14,19}}   :   {{2, 12}, {14,19}}
//{{8,14}, {10, 12}, {14,19}}
//int [][] result = {{8,12} , {14, 19}}

import java.util.*;

import static java.util.Arrays.sort;

// 1. start <= end
// 2. no shifts
// 3. no negatives
// 4. overlapping merge them
// 5. unsorted
public class TescoCoding {

    public static void main(String[] args) {
        TescoCoding tescoCoding = new TescoCoding();
       // int shifts[][] = {{8,10},{10,12},{14,19},{20, 23}};
      //  int shifts[][] = {{8,9}, {10, 12},{14,19}};
       int shifts[][] = {{2,9}, {7, 12},{14,19}};
     //   int shifts[][] = {{8,14}, {10, 12}, {14,19}};
      //  int shifts[][] = {};
//        testMergeShiftswithEmptyShifts();
//        testMergeShiftsUnsortedShifts();
//        testMergeShiftsSortedShifts();

    }

   class Interval {
       private int start;
       private int end;

       public Interval(int start, int end) {
           this.start = start;
           this.end = end;
       }

       public int getStart() {
           return start;
       }

       public void setStart(int start) {
           this.start = start;
       }

       public int getEnd() {
           return end;
       }

       public void setEnd(int end) {
           this.end = end;
       }

       @Override
       public String toString() {
           return "Interval{" +
                   "start=" + start +
                   ", end=" + end +
                   '}';
       }
   }

   public List<Interval> mergeShift(List<Interval> shifts) {

        if(shifts != null || shifts.size() < 1) return new ArrayList<>();

        int len = shifts.size();
        Collections.sort(shifts, (interval1, interval2) -> interval1.getStart() - interval2.getStart());

        List<Interval> mergedIntervalsList = new ArrayList<>();

        Interval mergedInterval = new Interval(shifts.get(0).getStart(), shifts.get(0).getEnd());

        for(int i = 1;i< len;i++) {
            Interval currInterval = shifts.get(i);
            if(currInterval.getEnd() <= mergedInterval.getEnd()){
                mergedInterval.setEnd(Math.max(currInterval.getEnd(), mergedInterval.getEnd()));
            }else{
                mergedIntervalsList.add(mergedInterval);
                mergedInterval = new Interval(shifts.get(i).getStart(), shifts.get(i).getEnd());
            }
        }

        mergedIntervalsList.add(mergedInterval);
        return mergedIntervalsList;
    }
}
