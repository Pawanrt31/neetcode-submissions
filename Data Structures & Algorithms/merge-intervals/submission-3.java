class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int[] firstInterval = intervals[0];
        result.add(firstInterval);
        for(int i=1;i<intervals.length;i++) {
            int firstStart = result.get(result.size() - 1)[0];
            int firstEnd = result.get(result.size() - 1)[1];
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart <= firstEnd) {
                result.get(result.size() - 1)[1] = Math.max(firstEnd, currentEnd);
            } else {
                result.add(new int[]{currentStart, currentEnd});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
