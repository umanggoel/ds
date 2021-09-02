package com.company.comoanyasked;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Microsoft {

    Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        Microsoft  microsoft = new Microsoft();
        int arr[] = {9,5,6,2};
        boolean isPossible = false;
        for(int i = 0;i< arr.length;i++) {
            if(microsoft.isSumPossible(arr, 7-arr[i])) {
                isPossible = true;
                break;
            }
        }

        if(isPossible)
            System.out.println("complete");
    }

    boolean isSumPossible(int arr[], int target) {

        if(map.get(target) != null) return map.get(target);

        if(target == 0) {
            map.put(target , true);
            return true;
        }

        if(target < 0) {
            map.put(target , false);
            return false;
        }

        for(int i = 0;i< arr.length;i++) {
            if(isSumPossible(arr, target-arr[i])) {
                map.put(target , true);
                return true;
            }
        }

        map.put(target , false);
        return false;
    }
}


// input  -> domains (Tags) (Huge)  (csv)
// output -> json
// domains -> -payment, -products , -order
// 1. if the file trigger // discarded
// 2. (scheduler) -> filePath -> kafka-stream -> (encode service)
// resolve() -> chunk() -> kafka-stream -> consumers() -> map-reduce
// consumers() -> resolver(filepath) -> publish to output
// Scheduler : Retries : Activity table in DB : Scanned, Published, Ready, Chunked, Processed, Assembled
// chunk : ready,pending,processed   updated_at