class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int finish = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] prerequisite: prerequisites) {
            indegrees[prerequisite[0]]++;
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            finish++;
            result.add(node);
            for(int neighbour: adjList.get(node)) {
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return finish == numCourses ? result.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}
