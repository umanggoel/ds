package com.company.arrays;

public class RefuellingStops871 {

    public static void main(String[] args) {
     RefuellingStops871  refuellingStops871 = new RefuellingStops871();

     int[][] sts = {{10,60},{20,30},{30,30},{60,40}};
     refuellingStops871.minRefuelStops(100,10,sts);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}