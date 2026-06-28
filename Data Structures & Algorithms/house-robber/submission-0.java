class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            memo[i] = -1;
        }
        return Math.max(dfs(0,nums),dfs(1,nums));
    }

    private int dfs(int i, int[] nums) {
        if(i >= nums.length) {
            return 0;
        }
        if(memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dfs(i+1,nums),nums[i] + dfs(i+2,nums));
        return memo[i];
    }
}
