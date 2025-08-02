class Solution {
    int temp;
    public int maxAreaOfIsland(int[][] grid) {
        int r= grid.length;
        int c= grid[0].length;
        int ans =0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    temp=0;
                    DFS(grid,i,j,r,c);
                    ans= Math.max(temp,ans);
                    
                }
            }
        }
        return ans;
    }

    public void DFS(int[][] grid, int i, int j, int row, int col){
        if(i<0 || j<0 || i>=row || j>=col || grid[i][j]==0) {
            return;
        } 
        grid[i][j] =0;
        temp++;
        DFS(grid, i+1, j, row, col);
        DFS(grid, i-1, j, row, col);
        DFS(grid, i, j+1, row, col);
        DFS(grid, i, j-1, row, col);

    }
}
