public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int element: nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            heap.offer(new int[]{m.getValue(), m.getKey()});
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = heap.poll()[1];
        }
        return result;
    }
}