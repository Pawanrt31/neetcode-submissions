class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null && speed == null || position.length == 0 && speed.length == 0) {
            return 0;
        }
        int[][] pairs = new int[position.length][2];
        for(int i=0;i<position.length;i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
        int fleets = 1;
        double prevTime = (double)(target - pairs[0][0])/pairs[0][1];
        for(int i=1;i<pairs.length;i++) {
            double currentTime = (double)(target - pairs[i][0])/pairs[i][1];
            if(currentTime > prevTime) {
                fleets++;
                prevTime = currentTime;
            }
        }
        return fleets;
    }
}
