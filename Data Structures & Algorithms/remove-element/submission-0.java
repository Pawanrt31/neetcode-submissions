class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int pointerNotEqualToVal = 0;
        for(int traversePointer = 0; traversePointer < nums.length; traversePointer++) {
            if(nums[traversePointer] != val) {
                nums[pointerNotEqualToVal] = nums[traversePointer];
                pointerNotEqualToVal++;
            }
        }
        return pointerNotEqualToVal;
    }
}