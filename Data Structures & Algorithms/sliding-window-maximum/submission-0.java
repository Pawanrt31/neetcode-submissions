class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[]{0};
        }
        int[] outputWindow = new int[nums.length - k + 1];
        int outputIdx = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i=0;i<nums.length;i++) {
            minHeap.offer(new int[]{nums[i], i});
            if(i >= k - 1) {
                while(minHeap.peek()[1] <= i - k) {
                    minHeap.poll();
                }
                outputWindow[outputIdx++] = minHeap.peek()[0];
            }
        } 
        return outputWindow;
    }
}
