package com.company.arrays;

import java.util.PriorityQueue;

class Solution1878 {

    public static void main(String[] args) {

        Solution1878 solution1878 = new Solution1878();
        //int[][] grid = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};
        //int[][] grid = {{7,7,7}};
        //int[][] grid = {{7,7,7},{56,78,34}};

        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution1878.getBiggestThree(grid);
    }


    public int[] getBiggestThree(int[][] grid) {

//        int result[] = new int[3];
        int len = grid.length;
        int n = grid[0].length;
//        if(len == 0) return result;

        int maxSize = Math.max(len / 2, n / 2);

        PriorityQueue<Integer> q = new PriorityQueue();
        int curr = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                curr = grid[i][j];
                int el = 0;
                if (q.size() == 3) {
                    el = q.poll();
                    q.offer(Math.max(el, curr));
                } else {
                    if (!q.contains(curr)) q.offer(curr);
                }


                for (int k = 1; k <= maxSize; k++) {
                    if (j - k < 0 || i + k >= len || j + k >= n || i + 2 * k >= len) {
                        continue;
                    } else {
                        //  int temp = curr + grid[i+k][j-k] + grid[i+k][j+k] + grid[i+2*k][j];

                        int temp = curr;
                        int t1, t2;
                        for (t1 = i + 1, t2 = j - 1; t1 < i + k && t2 > j - k; t1++, t2--) {
                            temp = temp + grid[t1][t2];
                        }

                        for (t1 = i + 1, t2 = j + 1; t1 < i + k && t2 < j + k; t1++, t2++) {
                            temp = temp + grid[t1][t2];
                        }

                        for (t1 = i + k, t2 = j - k; t1 < i + 2 * k && t2 < j; t1++, t2++) {
                            temp = temp + grid[t1][t2];
                        }

                        for (t1 = i + k, t2 = j + k; t1 < i + 2 * k && t2 > j; t1++, t2--) {
                            temp = temp + grid[t1][t2];
                        }

                        temp = temp + grid[i + 2 * k][j];
                        if (q.size() == 3) {
                            el = q.poll();
                            q.offer(Math.max(el, temp));
                        } else {
                            if (!q.contains(temp)) q.offer(temp);
                        }
                    }
                }
            }
        }

        int result[] = new int[q.size()];
        int i = q.size() - 1;
        while (!q.isEmpty()) {
            result[i] = q.poll();
            i--;
        }

        return result;
    }
}