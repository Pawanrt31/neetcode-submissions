class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] counter = new int[26];
        for(char ch: tasks) {
            counter[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count: counter) {
            if(count > 0) {
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !cooldownQueue.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                time = cooldownQueue.peek()[1];
            } else {
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    cooldownQueue.offer(new int[]{count, time+n});
                }
            }

            if(!cooldownQueue.isEmpty() && time == cooldownQueue.peek()[1]) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }
        return time;
    }
}
