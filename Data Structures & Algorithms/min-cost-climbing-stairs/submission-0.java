class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length+1;
        int[] arr = new int[len];
        if (len > 0) arr[0] = 0;
        if (len > 1) arr[1] = 0;
        for (int i = 2; i < len; i++) {
            int c_1 = arr[i-1] + cost[i-1];
            int c_2 = arr[i-2] + cost[i-2];
            // If stepping from 2 steps down is cheaper
            if (c_2 < c_1) {
                arr[i] = c_2;
            } else { 
                arr[i] = c_1;
            }
        }
        return arr[len-1];
    }
}
