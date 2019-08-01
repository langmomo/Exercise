package Util;

public class BFS {
    public int trapRainWater(int[][] heightMap) {
//    [
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
        int sum = 0;
        for(int i=1; i<heightMap.length-1; i++){
            for(int j=1; j<heightMap[0].length-1; j++){
                check(i, j, heightMap, 0);
            }
        }
        return sum;
    }
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int check(int x, int y, int[][] grid, int len){
        int min = 0;
        for(int i=0; i<4; i++){
            int newx = x+dir[i][0];
            int newy = y+dir[i][1];
            if(grid[newx][newy]>= grid[x][y]) return len;
            if(newx>=0 && newy>=0 && newx<grid.length &&newy<grid[0].length && grid[newx][newy]< grid[x][y]){
                int curlen = check(newx, newy, grid, len+1);
                if(curlen ==-1) return -1;
                min = Math.min(curlen, min);
            }else{
                return -1;
            }
        }
        return min;
    }

    public static void main(String[] args){
        //Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
        // compute the volume of water it is able to trap after raining.

        //4direction find the mininum


    }
}
