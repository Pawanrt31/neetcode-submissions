class Solution {
    public int maxArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = heights.length - 1;
        while(left < right) {
            int heightContained = Math.min(heights[left], heights[right]);
            int width = right - left;
            int area = heightContained * width;
            maxArea = Math.max(maxArea, area);
            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
