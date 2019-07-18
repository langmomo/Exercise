package az;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//694
//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//        Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
//
//        Example 1:
//
//        11000
//        11000
//        00011
//        00011
//        Given the above grid map, return 1.
//
//
//
//        Example 2:
//
//        11011
//        10000
//        00001
//        11011
//        Given the above grid map, return 3.
//
//        Notice that:
//
//        11
//        1
//        and
//
//        1
//        11
//        are considered different island shapes, because we do not consider reflection / rotation.
//
//
//
//        Note: The length of each dimension in the given grid does not exceed 50.
public class island {
    boolean[][] visited = null;

    public void solve(int[][] board){
        Set<List<List<Integer>>> lands = new HashSet<>();
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    List<List<Integer>> land = new ArrayList<>();
                    dfs(i, j, i, j, board, land);
                    lands.add(land);
                }
            }
        }
        System.out.println(lands.size());
    }

    public void dfs(int x, int y, int curx, int cury, int[][] board, List<List<Integer>> land){
        if(curx<0 || curx>=board.length || cury<0 || cury>= board[0].length|| visited[curx][cury] || board[curx][cury] == 0) return;
        visited[curx][cury] = true;
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(curx-x);
        tmp.add(cury-y);
        land.add(tmp);

        dfs(x,y,curx+1,cury, board, land);
        dfs(x,y,curx-1,cury, board, land);
        dfs(x,y,curx,cury+1, board, land);
        dfs(x,y,curx,cury-1, board, land);

    }

    public static void main(String[] args){
        int[][] board = new int[4][5];
        board[0] = new int[]{1,1,0,0,0};
        board[1] = new int[]{1,1,0,0,0};
        board[2] = new int[]{0,0,0,1,1};
        board[3] = new int[]{0,0,0,1,1};
        island il = new island();
        il.solve(board);

        board[0] = new int[]{1,1,0,1,1};
        board[1] = new int[]{1,0,0,0,0};
        board[2] = new int[]{0,0,0,0,1};
        board[3] = new int[]{1,1,0,1,1};
        il.solve(board);
    }

}
