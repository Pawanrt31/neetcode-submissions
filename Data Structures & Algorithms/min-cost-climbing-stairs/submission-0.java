class Solution {
    private int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        for(int i=0;i<cost.length;i++) {
            cache[i] = -1;
        }
        return Math.min(dfs(0,cost),dfs(1,cost));
    }

    private int dfs(int i, int[] cost) {
        if(i >= cost.length) {
            return 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }
        return cache[i] = cost[i] + Math.min(dfs(i+1,cost),dfs(i+2,cost)); 
    }
}
