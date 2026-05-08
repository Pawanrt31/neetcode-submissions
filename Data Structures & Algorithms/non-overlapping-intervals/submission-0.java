class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int nonOverlappingIntervals = 0;
        int previousStart = intervals[0][0];
        int previousEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart < previousEnd) {
                nonOverlappingIntervals++;
            } else {
                previousEnd = currentEnd;
            }
        }
        return nonOverlappingIntervals;
    }
}
