class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int element: nums) {
            if(!set.add(element)) {
                return true;
            }
        } 
        return false;
    }
}