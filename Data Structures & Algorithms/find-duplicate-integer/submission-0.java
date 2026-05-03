class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int slow = nums[0], fast = nums[0];
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
        }

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
