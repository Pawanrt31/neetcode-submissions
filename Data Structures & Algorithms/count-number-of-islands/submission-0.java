class Solution {

    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int ROW = grid.length, COLUMN = grid[0].length;
        int numIsland = 0;
        for(int r = 0;r<ROW;r++ ){
            for(int c=0;c<COLUMN;c++) {
                if(grid[r][c] == '1') {
                    dfs(grid,r,c);
                    numIsland++;
                }
            }
        }
        return numIsland;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        for(int[] direction: directions) {
            dfs(grid,r+direction[0],c+direction[1]);
        }

    }
}
