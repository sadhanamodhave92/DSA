class Solution {
    public int orangesRotting(int[][] grid) {
        int r= grid.length;
        int c= grid[0].length;
        int fresh=0;
       
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int[] dx= {1,0,-1,0};
        int[] dy= {0,1,0,-1};
        int min =0;

        while(!q.isEmpty()){
            int size = q.size(); // ✅ fix
            boolean changed = false;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int j=0;j<4;j++){
                    int x=curr[0]+dx[j];
                    int y=curr[1]+dy[j];
                    if(x>=0 && y>=0 && x<r && y<c && grid[x][y]==1){
                        grid[x][y] =2;
                        q.add(new int[]{x, y});
                        fresh--;
                        changed = true;
                    }
                }
            }
            if(changed) min++;
        }
        return (fresh==0) ? min : -1;
    }
}
