package Graph;

import java.util.*;

public class DFS {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    HashSet<List<String>> re =new HashSet<>();

    public void find(int[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(grid[i][j]==1){
                    List<String> list = new ArrayList<>();
                    traversal(i, j, grid, row, column, list, i, j);
                    Collections.sort(list);
                    re.add(list);
                }
            }
        }

        System.out.println(re.size());

    }
    public void traversal(int x, int y, int[][] grid, int row, int column, List<String> list, int sx, int sy){
        grid[x][y]=0;
        list.add(String.valueOf(x-sx)+String.valueOf(y-sy));
        for(int i=0; i<4; i++){
            int newx = x+dir[i][0];
            int newy = y+dir[i][1];
            if(newx>=0 && newy>=0 && newx<row &&newy<column && grid[newx][newy]==1){
                traversal(newx, newy, grid, row, column, list, sx, sy);
            }
        }
    }

    //course schedule find circle use dfs after generate graph
    boolean findCycleUtil(int i, boolean[] visited, boolean[] recStack, LinkedList<Integer>[] g) {
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        recStack[i] = true;
        for (int c : g[i]) {
            if (findCycleUtil(c, visited, recStack, g)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (findCycleUtil(i, visited, recStack, graph)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] grid = {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}};
        DFS dfs = new DFS();
        dfs.find(grid);
    }
}
