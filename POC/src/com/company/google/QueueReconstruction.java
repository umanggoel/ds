package com.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

    public static void main(String[] args) {
        QueueReconstruction queueReconstruction = new QueueReconstruction();

        int people[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        queueReconstruction.reconstructQueue(people);
    }

    public int[][] reconstructQueue(int[][] people) {

        if(people.length == 0 || people.length == 1) return people;

        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1];
            }
        });

        List<List<Integer>> result= new ArrayList<>();
        result.add(Arrays.asList(people[0][0],people[0][1]));

        for(int i=1;i<people.length;i++){
            int count  = 0;
            boolean inserted = false;
            int n =  people[i][1];
            while(count < result.size()){
                if(n > 0){
                    if(people[i][0] <= result.get(count).get(0)){
                        n = n-1;
                    }
                }else if(n == 0 && people[i][0] < result.get(count).get(0)){
                    result.add(count,Arrays.asList(people[i][0],people[i][1]));
                    inserted = true;
                    break;
                }
                count++;
            }
            if(!inserted) result.add(Arrays.asList(people[i][0],people[i][1]));
        }

        int[][] finalResult = new int[people.length][2];

        int count =0;
        for(List<Integer> list : result){
            finalResult[count][0] = list.get(0);
            finalResult[count][1] = list.get(1);
            count++;
        }
        return  finalResult;
    }
}
