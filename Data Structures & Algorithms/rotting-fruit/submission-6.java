class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        int time = 0;
        int fresh = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();
            for(int i=0;i<length;i++) {
                int[] pos = queue.poll();
                int r = pos[0], c = pos[1];
                for(int[] direction: directions) {
                    int row = r + direction[0], column = c + direction[1];
                    if(row >= 0 && column >=0 && row < grid.length && column < grid[0].length && grid[row][column] == 1) {
                        grid[row][column] = 2;
                        queue.offer(new int[]{row, column});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
