class Solution {
    public int orangesRotting(int[][] grid) {
        int r= grid.length;
        int c= grid[0].length;
        int fresh=0, rotten=0;
       
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    rotten++;
                    q.add(new Pair<>(i, j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int[] dx= {1,0,-1,0};
        int[] dy= {0,1,0,-1};
        int min =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                   Pair<Integer, Integer> pair = q.poll();
                    for(int j=0;j<4;j++){
                        int x=pair.getKey()+dx[j];
                        int y=pair.getValue()+dy[j];
                        if(x>=0 && y>=0 && x<r && y<c && grid[x][y]==1){
                            grid[x][y] =2;
                            q.add(new Pair<>(x, y));
                            fresh--;
                        }
                    }
            }
             if(q.size()>0){
                min++;
            }
           
        }
        if(fresh==0){
            return min;
        }
        return -1;
        
    }
}