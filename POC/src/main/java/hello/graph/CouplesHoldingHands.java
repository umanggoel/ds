class Solution {
    public int minSwapsCouples(int[] a) {
        int n = a.length;
        DSU dsu = new DSU(n/2);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0;i<n;i++) {
            map.put(a[i], i/2);
        }
        
        for (int i=0;i<n;i++) {
            if (a[i]%2==0) {
                int node1 = map.get(a[i]);
                int node2 = map.get(a[i]+1);
                
                dsu.union(node1, node2);
            }
        }
        
        return dsu.count;
    }
    
    private static class DSU {
        private int[] rank;
        private int[] parent;
        private int count; // Count of all edges 
        
        DSU(int size) {
            rank = new int[size];
            parent = new int[size];
            count = 0;
            
            for (int i=0;i<size;i++) {
                parent[i] = i;
            }
        }
        
        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            
            return parent[x] = find(parent[x]);
        }
        
        private void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            
            if (rootx == rooty) {
                return;
            }
            
            if (rank[rootx]<rank[rooty]) {
                parent[rootx] = rooty;
            } else if (rank[rootx]>rank[rooty]) {
                parent[rooty] = rootx;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            
            count++;
            
        }
        
    }
}
