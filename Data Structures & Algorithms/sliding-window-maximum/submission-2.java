class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[]{0};
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        int outputIdx = 0;
        for(int i=0;i<nums.length;i++) {
            while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {

                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1) {
                output[outputIdx++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}