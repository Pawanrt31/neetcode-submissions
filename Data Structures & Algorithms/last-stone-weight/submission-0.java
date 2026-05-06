class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int stone: stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1) {
            if(maxHeap.size() >= 2) {
                int y = maxHeap.poll();
                int x = maxHeap.poll();
                if(y > x) {
                    maxHeap.offer(y - x);
                }
            }
        }
        return (maxHeap.size() > 0 ? maxHeap.peek() : 0);
    }
}
