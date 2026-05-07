/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) {
            return true;
        }
        Collections.sort(intervals, (interval1, interval2) -> interval1.start - interval2.start);
        for(int i=1;i<intervals.size();i++) {
            if(intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }
        return true;
        
    }
}
