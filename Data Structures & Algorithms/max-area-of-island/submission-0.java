class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for(int row = 0; row < grid.length;row++) {
            for(int column = 0;column < grid[0].length;column++) {
                if(grid[row][column] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, row, column));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r <0 || c < 0 || r >=grid.length|| c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        int area = 1;
        grid[r][c] = 0;
        for(int[] direction: directions) {
            area += dfs(grid,r + direction[0], c + direction[1]);
        }
        return area;
    }
}
