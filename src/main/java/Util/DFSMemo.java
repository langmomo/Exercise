package Util;

import java.util.Arrays;
//1140. Stone Game II
public class DFSMemo {

    class template{
        int[][] memo;
        public int ascendingPathLength(int[] grid){
            if(grid.length==0) return 0;
            memo = new int[grid.length][grid.length];

            return helper(grid.length, 0, grid, 1);

        }

        public int helper(int row,  int x, int[] grid, int M){
            if(x>=row){ //退出条件

                return 0;
            }

            if(memo[x][M]!=0) { //对于访问过的，直接返回

                return memo[x][M];
            }

            int currlen = Integer.MAX_VALUE;
            for(int i=1; i<=2*M; i++){ //循环
                currlen = Math.min(helper(row,i+x, grid,Math.max(M, i)), currlen); //获取子问题最佳

            }
            memo[x][M] = grid[x]-currlen; //更新当前点最佳（子问题最佳+当前点值）

            return memo[x][M];
        }
    }


    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    int max = 0;
    int[] memo;
    public int ascendingPathLength(int[][] grid){
        if(grid.length==0) return 0;
        memo = new int[grid.length*grid[0].length];
        Arrays.fill(memo, -1);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int cur = helper(grid.length, grid[0].length, i, j, grid, -1);

                max =  Math.max(max, cur);
            }
        }
        System.out.println(max);
        return max;
    }

    public int helper(int row, int col, int x, int y, int[][] grid, int prev){
        if(x<0||y<0||x>=row||y>=col||grid[x][y]<=prev){

            return 0;
        }

        if(memo[x*col+y]!=-1) {

            return memo[x*col+y];
        }
        int currlen = 0;
        for(int i=0; i<4; i++){
            int newx = x+dir[i][0];
            int newy = y+dir[i][1];

            currlen = Math.max(helper(row, col,newx, newy, grid, grid[x][y]), currlen);

        }
        memo[x*col+y] = currlen+1;

        return currlen+1;
    }

    public static void main(String[] args){
        DFSMemo dfs = new DFSMemo();

        int[][] grid = {{9,9,4},{6,6,8},{2,1,1}};
        dfs.ascendingPathLength(grid);
    }
}
