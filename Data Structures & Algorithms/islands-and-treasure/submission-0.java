class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return;
        }
        int ROW = grid.length, COLUMN = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int row=0;row<ROW;row++) {
            for(int column=0;column<COLUMN;column++) {
                if(grid[row][column] == 0) {
                    queue.offer(new int[]{row, column});
                }
            }
        }
        if(queue.size() == 0) {
            return;
        }
        int[][] directions = {{-1,0},{0,-1},{1,0},{0,1}};
        while(!queue.isEmpty()) {
            int[] gridPos = queue.poll();
            int r = gridPos[0], c = gridPos[1];
            for(int[] direction: directions) {
                int row = r + direction[0], column = c + direction[1];
                if(row < 0 || column < 0 || row >= ROW || column >= COLUMN || grid[row][column] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[]{row, column});
                grid[row][column] = grid[r][c] + 1;
            }
        }
    }
}
