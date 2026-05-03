class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null && heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] leftMost = new int[heights.length];
        int[] rightMost = new int[heights.length];
        for(int i=0;i<heights.length;i++) {
            leftMost[i] = -1;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=heights.length-1; i>=0; i--) {
            rightMost[i] = heights.length;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i=0;i<heights.length;i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            int width = (rightMost[i] - leftMost[i] + 1);
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}
