package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Goldenman {

    public static int[][] gridGame(int[][] grid, int k, int[] rules){

        for(int i=0; i<k; i++){
            grid = traversal(grid.length, grid[0].length, grid, rules);
        }
        outputArray(grid);
        return grid;
    }
    static int[][] dir = {{1,0},{-1,0},{1,1},{-1,1},{0,1},{0,-1},{-1,-1},{1,-1}};
    public static int[][] traversal(int row, int col, int[][] grid, int[] rules){
        int[][] newgrid = new int[grid.length][grid[0].length];
        for(int x=0; x<row; x++){
            for(int y=0; y<col; y++){
                int sum = 0;
                for(int i=0; i<8; i++){
                    int newx = x+dir[i][0];
                    int newy = y+dir[i][1];
                    if(newx>=0 && newy>=0 && newx<row && newy<col && grid[newx][newy]==1){
                        sum+=1;
                    }
                }

                for(int index: rules){
                    if(sum==index){
                        newgrid[x][y] = 1;
                    }
                }

            }
        }
        return newgrid;
    }


    public static void mostCommon(String str)
    {
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']+=1;
        }
        int max = 0;
        int total = 0;
        int[] ori = new int[26];
        for(int i=0; i<str.length(); i++){
            if(arr[str.charAt(i)-'a']==1) continue;
            int offset = (arr[str.charAt(i)-'a'])/2-ori[str.charAt(i)-'a'];
            ori[str.charAt(i)-'a']++;
            total+=offset>0?1:-1;
            max =Math.max(max, total);

        }
        System.out.println(max);
    }


    public static String rotateTheString(String str, int[] directions, int[] amount){
        int total = 0;
        for(int i=0; i<directions.length; i++){
            total += directions[i]==0?-amount[i]  :amount[i];
        }

        int len = total % str.length();
        if(len<0){
            String left = str.substring(0, len+1);
            String right = str.substring(len+1);
            return right+left;
        }else if(len>0){
            String left = str.substring(str.length()-len);
            String right = str.substring(0, str.length()-len);
            return left+right;
        }else{
            return str;
        }
    }


    public static String[] strangeSort(int[] mapping, String[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<mapping.length; i++){
            map.put(mapping[i], i);
        }
        for(int i=0; i<nums.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<nums[i].length(); j++){
                sb.append(map.get(nums[i].charAt(j)));
            }
            nums[i] = sb.toString();
        }
        return nums;
    }

    //prerequest  --- contains A,B,C get substring
    public static List<String> analyzeInvestiment(String str){
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){

            int[] req = new int[3];

            for(int j=i; j<str.length(); j++){

                char c = str.charAt(j);
                if(c=='A') req[0]=1;
                if(c=='B') req[1]=1;
                if(c=='C') req[2]=1;
                if(req[0]==1 && req[1]==1 && req[2]==1) list.add(str.substring(i, j+1));

            }
        }
        System.out.println(list);
        return list;
    }


    public static void outputArray(int[][] grid){
        for(int[] row: grid){
            StringBuilder sb = new StringBuilder();
            Arrays.stream(row).forEach(item-> sb.append(item));
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,1,0},{1,1,0,0}};
        gridGame(grid, 2, new int[]{3,5});
        mostCommon("ddddabcdecdcdefgcdde");
        analyzeInvestiment("ABBCZBAC");
    }
}
