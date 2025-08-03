class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int r= maze.length;
        int c= maze[0].length;
        int steps=0;
        Queue<int[]> q = new LinkedList<>();
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        q.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        while(!q.isEmpty()){
            int[] curr= q.poll();
            for(int j=0;j<4;j++){
                int x=curr[0]+dx[j];
                int y=curr[1]+dy[j];
                if(x>=0 && y>=0 && x<r & y<c && maze[x][y]=='.'){
                    if(x==0|| x==r-1 || y==0 ||y==c-1){
                        return curr[2]+1;
                    }
                    maze[x][y] ='+';
                    q.offer(new int[]{x,y,curr[2]+1});
                }
            }
        }
        return -1;
    }
}