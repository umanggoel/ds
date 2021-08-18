package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class FrogJump403 {

    public static void main(String[] args) {
            FrogJump403 frogJump403 = new FrogJump403();
            frogJump403.canCross(new int[]{0,1,3,5,6,8,12,17});
    }


        public boolean canCross(int[] stones) {

            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(Integer i: stones) {
                map.put(i,count++);
            }

            return foo(stones, 0, 1, map);
        }

        private boolean foo(int stones[], int curr, int last, Map<Integer, Integer> set) {
            if(stones.length == curr) return true;
            if(stones.length < curr) return false;

            if(last != 0 && set.get(stones[curr]+last) != null){
                return foo(stones, set.get(stones[curr]+last), last-1, set)
                        || foo(stones, set.get(stones[curr]+last), last, set)
                        || foo(stones, set.get(stones[curr]+last), last+1, set);
            }

            return false;
        }
}