class Solution {
    // TC: O(n^2)
    // SC: O(n)
    public int minCostConnectPoints(int[][] pts) {
        int n = pts.length; // n nodes: [0, n-1]
        boolean[] inMST = new boolean[n];
        inMST[0] = true;
        int cnt = 1; // total number of nodes in MST
        int res = 0; // total weight is now 0
        int cur = 0; // latest node connected to be part of MST
        
        int[] minDist = new int[n]; // min distance from MST to rest of the nodes
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        while (cnt < n) {
            int next = -1;
            
            for (int j = 0; j < n; j++) { // n-1
                if (inMST[j]) continue;
                minDist[j] = Math.min(minDist[j], getDist(pts[cur], pts[j]));
                if (next == -1 || minDist[j] < minDist[next]) next = j;
            }
            
            cur = next;
            res += minDist[cur];
            inMST[cur] = true;
            cnt++;
        }
        
        return res;
    }

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
