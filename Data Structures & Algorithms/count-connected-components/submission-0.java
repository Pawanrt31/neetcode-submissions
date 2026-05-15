class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0) {
            return 0;
        }
        int components = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for(int node = 0; node< n; node++) {
            if(!visited[node]) {
                dfs(adjList,node,visited);
                components++;
            }
        }
        return components;
    }

    private void dfs(List<List<Integer>> adjList, int node, boolean[] visited) {
        visited[node] = true;
        for(int neighbour: adjList.get(node)) {
            if(!visited[neighbour]) {
                dfs(adjList, neighbour, visited);
            }
        }
    }
}
