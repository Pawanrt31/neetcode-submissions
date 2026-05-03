class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}