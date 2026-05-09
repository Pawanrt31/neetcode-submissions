class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int jumps = 0, left = 0, right = 0;
        while(right < nums.length - 1) {
            int farthest = 0;
            for(int i=left;i<=right;i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}
