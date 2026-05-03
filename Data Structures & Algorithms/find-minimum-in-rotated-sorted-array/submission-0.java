class Solution {
    public int findMin(int[] nums) {
        if(nums == null ||nums.length == 0) {
            return 0;
        }
        int minimum = Integer.MAX_VALUE;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[low] <= nums[high]) {
                minimum = Math.min(minimum, nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]) {
                minimum = Math.min(minimum, nums[low]);
                low = mid + 1;
            } else {
                minimum = Math.min(minimum, nums[mid]);
                high = mid - 1;
            }
        }
        return minimum;
    }
}
