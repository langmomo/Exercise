package Graph;

import java.util.LinkedList;
import java.util.Queue;

//317
public class ShortestPath {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid) {
        int[][] board = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] p = q.poll();
                        int x = p[0];
                        int y = p[1];

                        for(int k=0; k<4; k++){
                            int newx = x+dir[k][0];
                            int newy = y+dir[k][1];
                            if(newx>=0 && newy >=0 && newx<grid.length && newy < grid[0].length && grid[newx][newy]!=1 && grid[newx][newy]!=2){
                                board[newx][newy] += board[x][y]+1;
                                q.offer(new int[]{newx, newy});
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args){
        //input [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
        //output 7

        int[][] arr =  {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    }


}
