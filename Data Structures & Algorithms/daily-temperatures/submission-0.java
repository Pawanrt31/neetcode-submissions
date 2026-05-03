class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[]{0};
        }
        int[] dailyTemperature = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++) {
            int currentTemperature = temperatures[i];
            while(!stack.isEmpty() && currentTemperature > stack.peek()[0]) {
                int[] temperature = stack.pop();
                dailyTemperature[temperature[1]] = i - temperature[1];
            }
            stack.push(new int[]{currentTemperature, i});
        }
        return dailyTemperature;
    }
}
