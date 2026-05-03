class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int uniquePointer = 0;
        for(int traversePointer = 0; traversePointer < nums.length; traversePointer++) {
            if(nums[uniquePointer] != nums[traversePointer]) {
                nums[++uniquePointer] = nums[traversePointer];
            }
        }
        return uniquePointer + 1;
    }
}