class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0) {
            return 0;
        }
        int low = 1, high = Arrays.stream(piles).max().getAsInt(), resp = high;
        while(low <= high) {
            int mid = (low + high) / 2;
            long totalPile = 0;
            for(int p: piles) {
                totalPile += Math.ceil((double)p / mid);
            } 
            if(totalPile <= h) {
                resp = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return resp;
    }
}
