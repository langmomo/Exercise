package Util;

import java.util.*;

public class Backtracking {
    //with memorize
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public static int findLongsetPathWithGraph(int[][] board){
        boolean[][] visited = new boolean[board.length][board[0].length];
        int max = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                max = Math.max(max,helper(i,j, board, visited));
            }
        }
        return max;

    }
    static HashMap<String, Integer> path = new HashMap<>();
    public static int helper(int x, int y, int[][] grid, boolean[][] visit){
        int row = grid.length;
        int column = grid[0].length;
        int maxLevel = 0;
        if(path.containsKey(x+","+y)) return path.get(x+","+y);
        for(int i=0; i<4; i++){
            int newx = x+dir[i][0];
            int newy = y+dir[i][1];
            
            if(newx>=0 && newy>=0 && newx<row && newy<column && !visit[newx][newy] && grid[newx][newy]>grid[x][y]){
                visit[newx][newy] = true;
                maxLevel = Math.max(maxLevel, helper(newx, newy, grid, visit));
                visit[newx][newy] = false;
            }
        }

        path.put(x+","+y, maxLevel+1);
        return maxLevel+1;

    }


    public static void abbreviation(String str){
        int[] arr = new int[str.length()];
        solve(str, arr, 0);
        list.forEach(item->System.out.println(item));
    }
    static Set<String> list = new HashSet<>();
    public static void solve(String str, int[] arr, int start){
        if(start ==str.length()){
            list.add(getString(arr, str));
            return;
        }
           for(int i=start; i<str.length(); i++){
               arr[i] = 1;
               solve(str, arr, start+1);

               arr[i]=0;
           }
    }
    
    public static String getString(int[] arr, String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< arr.length; i++){
            if(arr[i]==0){
                stack.push(str.charAt(i));
            }else{
                if(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    int temp = (int)stack.pop()+1;
                    stack.push((char)temp);
                }else{
                    stack.push('1');
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args){
//        int[][] matrix = {{0},{1},{5},{5}};
//        System.out.println(findLongsetPathWithGraph(matrix));
        abbreviation("word");

    }
}
