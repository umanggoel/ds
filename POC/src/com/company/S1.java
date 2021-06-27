package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class S1 {

    public static void main(String[] args) {
//        String[] c = {"Bangalore", "Pune", "San Fransisco", "New York City"};
//        Arrays.sort(c, (a, b)-> b.compareTo(a));
//        System.out.print(Arrays.binarySearch(c,"New York City"));

        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(2);
        reductionCost(Arrays.asList(1,2,3,4));
    }

    public static int reductionCost(List<Integer> num) {


        int cost = 0;
        PriorityQueue<Integer> i = new PriorityQueue<>();

        for(Integer n : num) {
            i.add(n);
        }

        while(i.size() >1) {
            int sum =  i.remove()+ i.remove();
            cost+=sum;
            i.add(sum);
        }

        return cost;

    }

    public static int countStudents(List<Integer> height) {

        int result =0;

        List<Integer> temp = new ArrayList<>();
        temp.addAll(height);
        Collections.sort(temp);

        for(int i= 0;i< temp.size();i++) {
            if(temp.get(i) != height.get(i)) result++;
        }

        return result;
    }

    public static long minTime(List<Integer> batchSize, List<Integer> processingTime, List<Integer> numTasks) {
        long arr[] = new long[batchSize.size()];


        for(int i=0;i< batchSize.size();i++) {
            long n = (long) Math.ceil(numTasks.get(i)/batchSize.get(i));
            arr[i] = n * processingTime.get(i);
        }

        long result = Long.MIN_VALUE;

        for(int i=0;i<batchSize.size();i++) {
            if(arr[i] > result) result = arr[i];
        }

        return result;

    }
}
