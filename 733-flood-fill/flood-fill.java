class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int oldColor= image[sr][sc];
        if(oldColor == color) return image;
        DFS(image,sr,sc,oldColor,color);
        return image;
    }
    private void DFS(int[][] image, int i, int j, int oldColor, int color){
        int row = image.length;
        int col= image[0].length;
         if(i<0 || j<0 || i>=row || j>=col || image[i][j]!=oldColor) {
            return;
        } 
        image[i][j] = color;;
        DFS(image, i+1, j,oldColor, color);
        DFS(image, i-1, j, oldColor, color);
        DFS(image, i, j+1, oldColor, color);
        DFS(image, i, j-1, oldColor, color);
    }
}