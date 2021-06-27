package com.company.arrays;

public class StoneGame1690 {

    public static void main(String[] args) {
        StoneGame1690 stoneGame1690 = new StoneGame1690();
        int stones[] ={5,3,1,4,2};
        stoneGame1690.stoneGameVII(stones);
    }

    int max = Integer.MIN_VALUE;
    public int stoneGameVII(int[] stones) {
        foo(true, false,0,stones.length-1, stones,0,0);
        return max;
    }

    void foo(boolean a1,boolean b1, int start, int end , int[] stones, int sc1, int sc2) {

        if(start == end) {
            System.out.println(sc1 + ":" + sc2);
            max = Math.max(max, sc1-sc2);
            return;
        }

        int tempStart = sum(start+1, end, stones);
        int tempEnd = sum(start, end-1, stones);
        if(a1) {
            if(sc1+tempStart-sc2 > sc1+tempEnd-sc2){
                foo(false, true, start+1, end, stones,sc1+tempStart,sc2);
            }else{
                foo(false, true, start, end-1, stones,sc1+tempEnd,sc2);
            }
        }else{
            if(sc1-sc2-tempStart > sc1-tempEnd-sc1){
                foo(true, false, start+1, end, stones,sc1,sc2+tempStart);
            }else{
                foo(true, false, start, end-1, stones,sc1,sc2+tempEnd);
            }
        }

    }

    int sum (int start, int end , int[] stones){
        int sum = 0;
        for(int i=start;i<=end;i++) {
            sum= sum+stones[i];
        }
        return sum;
    }
}