class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        if(hand == null || hand.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int element: hand) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for(int element: hand) {
            int start = element;
            while(map.getOrDefault(start - 1,0) > 0) {
                start--;
            }
            while(start <= element) {
                while(map.getOrDefault(start,0) > 0) {
                    for(int i=start;i<start + groupSize;i++) {
                        if(map.getOrDefault(i,0) == 0) {
                            return false;
                        }
                        map.put(i,map.getOrDefault(i,0) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
