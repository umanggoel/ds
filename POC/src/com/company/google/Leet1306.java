package com.company.google;

public class Leet1306 {
    public boolean canReach(int[] arr, int start) {
        int visited[] = new int[arr.length];
        return canReachZero(arr, start,arr.length,visited);
    }

    private boolean canReachZero(int[] arr, int start, int n, int[] visited){
        if(start >= n || start < 0 || visited[start] == 1) return false;
        if(arr[start] == 0) return true;

        visited[start] = 1;
        boolean foundleft = canReachZero(arr,start+arr[start],n, visited);
        boolean foundright =  canReachZero(arr,start-arr[start],n, visited);

        visited[start] = 0;
        return foundleft || foundright;
    }
}
