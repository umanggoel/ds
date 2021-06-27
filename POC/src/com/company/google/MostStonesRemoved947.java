package com.company.google;

public class MostStonesRemoved947 {

    public int removeStones(int[][] stones) {

        int len = stones.length;
        DisjointSet ds = new DisjointSet(len);

        for(int i =0;i< len;i++) {

            for(int j =0;j< len ;j++) {
                if(i!=j && (stones[i][0] == stones[j][0] || stones[j][1] == stones[i][1])){
                    ds.connect(i,j);
                }
            }
        }
        return len-ds.getCount();
    }

    class DisjointSet {
        int count = 0;
        int [] parent;

        DisjointSet(int n) {
            parent = new int[n];
            for(int i = 0;i< n;i++) {
                parent[i] = i;
                count++;
            }
        }

        int find(int i) {
            if(parent[i] != i){
                return find(parent[i]);
            }
            return i;
        }

        void connect(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if(pi == pj) return;

            parent[pj] = pi;
            count--;
        }

        int getCount(){
            return count;
        }

    }
}