class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        if(points == null || points.length == 0) {
            return result;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0]*b[0] + b[1]*b[1],a[0]*a[0] + a[1]*a[1]));
        for(int[] point: points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int idx = 0;
        while(!maxHeap.isEmpty()) {
            result[idx++] = maxHeap.poll();
        }
        return result;
    }
}
