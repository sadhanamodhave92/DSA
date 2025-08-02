class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxarea = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int area = DFS(grid, i, j, r, c);
                    maxarea = Math.max(area, maxarea);
                }
            }
        }
        return maxarea;
    }

    public int DFS(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;

        area += DFS(grid, i + 1, j, row, col);
        area += DFS(grid, i - 1, j, row, col);
        area += DFS(grid, i, j + 1, row, col);
        area += DFS(grid, i, j - 1, row, col);

        return area;
    }
}
