package com.company.arrays;

import com.company.common.Util;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {

    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> elements   = new HashMap();
        for(int i=0;i<nums.length;i++){
            Integer count = elements.get(nums[i]);
            if(count != null){
                count++;
            } else{
                count =1;
            }

            elements.put(nums[i], count);
        }

        for(Map.Entry entry:elements.entrySet()){
            if((int)entry.getValue()==1){
                return (int)entry.getKey();
            }
        }
        return -1;
    }

    public static  void moveZeroes(int[] nums) {
        int index = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0 && index == -1){
                index = i;
            }else if(nums[i] != 0 && index != -1){
                int temp = nums[i];
                nums[i] = 0;
                nums[index] = temp;
                i = index;
                index = -1;
            }
        }
    }

    static HashMap<Integer, Integer> elements = new HashMap();
    public static boolean isHappy(int n) {
        if(n == 1) return true;
        if(n == 0 || elements.containsKey(n)) return false;

        elements.put(n, 1);
        int sum = 0;
        while(n != 0){
            sum = sum + (n%10)*(n%10);
            n = n/10;
        }
        return isHappy(sum);

    }

    //https://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
    public void printJumpingNumbers(int k){

        if(k<0){
            return;
        }

        System.out.print(0+",");
        List<Integer> list = new ArrayList<>();
        list.stream().sorted().collect(Collectors.toList());
        if(k<10) for(int i=1;i<k;i++) {
            System.out.print(i+",");
            return;
        }

        int count = Util.countDigits(k);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        for(int i=1;i<count;i++) {
            List<Integer> list2 = new ArrayList<>();
            for(int temp :list){
                System.out.print(temp+",");
                if(temp-1 >= 0){
                    int t1 = temp*10+temp-1;
                    if(t1 < k) {
                        System.out.print(t1+",");
                        list2.add(t1);
                    }
                }
                int t2 = temp*10+temp+1;
                if(t2 < k) {
                    System.out.print(t2+",");
                    list2.add(t2);
                }

            }
            list = list2;
        }


    }

    //maximum area in histogram[1,2,1,2,3,1]
    public int maxHistogramArea(int [] heights){

        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        int i=0;
        while(i<heights.length){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
                i++;
            } else{
                int curr = stack.pop();
                int temp = stack.isEmpty() ? i:i-stack.peek()-1;
                int area = heights[curr]*temp;
                if(area > max_area){
                    max_area =area;
                }
            }
        }

        while(!stack.isEmpty()){
            int curr = stack.pop();
            int temp = stack.isEmpty() ? i:i-stack.peek()-1;
            int area = heights[curr]*temp;
            if(area > max_area){
                max_area =area;
            }
        }
        return max_area;
    }

    public static int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int [] l = new int[len];
        int [] r = new int[len];
        int result[] = new int[len];

        l[0] = 1;
        for(int i=1;i < len;i++) {
            l[i] = nums[i-1]*l[i-1];
        }

        r[len-1] = 1;
        for(int i=len-2 ; i >= 0;i--) {
            r[i] = nums[i+1]*r[i+1];
        }

        result[0] = r[0];
        result[len-1] = l[len-1];
        for(int i=1;i<len-2;i++){
            result[i] = l[i-1]*r[i+1];
        }
        return result;
    }

    public static List<Integer> maxset(List<Integer> A) {

        ArrayList<ArrayList<Integer>> sub = new ArrayList<>();

        int startIndex = 0;
        int endIndex = 0;
        int max = 0;
        int mstart=0;
        int mend = 0;
        int curr = 0;
        for(int i = 0;i< A.size();i++) {
            if(A.get(i) < 0){
                if(curr > max) {
                    max = curr;
                    mstart =startIndex;
                    mend = i-1;
                }else if(curr == max){
                    endIndex = i-1;
                    if(endIndex-startIndex > mend-mstart){
                        mstart = startIndex;
                        mend = endIndex;
                    }
                }
                startIndex = i+1;
                curr = 0;
            }else{
                curr = curr+A.get(i);
            }
        }

        if(curr > max) {
            mstart =startIndex;
            mend = A.size()-1;
        }else if(curr == max){
            if(endIndex-startIndex > mend-mstart){
                mstart = startIndex;
                mend = endIndex;
            }
        }

        return A.subList(mstart,mend+1);
    }

    public static int repeatedNumber(final List<Integer> a) {
        List<Integer> result = new ArrayList<>();
        result.addAll(a);
        result = result.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }).collect(Collectors.toList());

        if(a.size() == 1) return a.get(0);
        double reqCount = Math.ceil(a.size()/3.0);
        int count = 1;
        for(int i=1;i<result.size();i++){
            if(result.get(i).equals(result.get(i-1))){
                count++;
            }else{
                if(count >= reqCount) {
                    return result.get(i-1);
                } else{
                    System.out.println(count);
                    count = 1;
                }

            }
        }
        return 0;
    }

    public int findJudge(int N, int[][] trust) {

        if(trust== null ) return -1;

        Arrays.sort(trust, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int judge = -1;
        Map<Integer,Integer> judgeCandidate = new HashMap<>();
        judgeCandidate.put(trust[0][1], 1);
        Set<Integer> temp = new HashSet<>();
        temp.add(trust[0][0]);
        for(int i=1;i<trust.length;i++){
            temp.add(trust[i][0]);
            if(judgeCandidate.containsKey(trust[i][1])){
                judgeCandidate.put(trust[i][1], judgeCandidate.get(trust[i][1])+1);
            } else{
                judgeCandidate.put(trust[i][1],1);
            }
        }

        List<Map.Entry> l = judgeCandidate.entrySet().stream().filter(entry-> entry.getValue() == N-1).collect(Collectors.toList());

        if(l.size() == 1){
            int key =  (int)l.get(0).getKey();
            if(!temp.contains(key)) judge = key;
        }
        return judge;
    }

    public boolean isPerfectSquare(int num) {

        if(num ==1) return true;
        int start = 1;
        int end = num-1;
        int mid = (start+end)/2;
        while(start<=end){
            int temp = mid*mid;
            if(temp == num) return true;
            else if(temp > num){
                end = mid-1;
            } else{
                start= mid+1;
            }
            mid = (start+end)/2;
        }

        return false;
    }

    public boolean checkStraightLine(int[][] coordinates) {

        boolean result = false;
        Arrays.sort(coordinates, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });

        int cx = Math.abs(coordinates[1][0]-coordinates[0][0]);
        int cy = Math.abs(coordinates[1][1]-coordinates[0][1]);


        for(int i=2;i< coordinates.length;i++){
            int tx = Math.abs(coordinates[i][0]-coordinates[i-1][0]);
            int ty = Math.abs(coordinates[i][1]-coordinates[i-1][1]);

            if(cx == 0) {
                if (tx != 0) {
                    return false;
                } else {
                    continue;
                }
            }

            if(cy == 0) {
                if (ty != 0) {
                    return false;
                } else {
                    continue;
                }
            }


            if(ty != tx){
                return false;
            }
        }
        return true;

    }

    public int findComplement(int num) {

        Stack<Integer> stack = new Stack<>();
        int remain = num%2;
        while(num/2 != 0){
            stack.push(num%2);
            num = num/2;
            remain = num%2;
        }

        stack.push(remain);
        System.out.println(stack);
        int i = stack.size()-1;
        double result = 0;
        while(!stack.isEmpty()){
            int ele = stack.pop();
            if(ele == 0){
                ele = 1;
            } else {
                ele =0;
            }
                result = result+ ele* Math.pow(2,i);
            i=i-1;
        }
        return (int)result;
    }


//skyline problem

}




