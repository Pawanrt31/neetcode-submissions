class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        int finish = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++) {
            indegrees[prerequisites[i][1]]++;
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<indegrees.length;i++) {
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            finish++;
            for(int neighbour: adjList.get(node)) {
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return finish == numCourses;
    }
}
