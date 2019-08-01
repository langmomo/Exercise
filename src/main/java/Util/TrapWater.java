package Util;
// find point \/  寻找更低从低低一侧开始|| find point /\  寻找更高从高低一侧开始
public class TrapWater {
    public static int twoPointerTrap(int[] arr){
        //two direction array
        int start = 0;
        int end = arr.length-1;
        int sum = 0;
        while(start<=end){
            if(arr[start]<arr[end]){
                start++;
                if(arr[start]<arr[start-1]){
                    sum+=arr[start-1]-arr[start];
                }
            }else{
                end--;
                if(arr[end]<arr[end+1]){
                    sum+=arr[end+1]-arr[end];
                }
            }
        }
        return sum;

    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    //    [
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
    public static int twoPointerTrapWithGraph(int[][] heightMap){
        //4 direction
        int sum = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        for(int i=0; i<heightMap.length; i++){
            for(int j=0; j<heightMap[0].length; j++){
                if(i==0 || i==(row-1)||j==0||j==(col-1)) continue;
                int rowmin = heightMap[i][j-1]< heightMap[i][col-1]? heightMap[i][j-1]:heightMap[i][col-1];
                int colmin = heightMap[i-1][j]<heightMap[row-1][j]? heightMap[i-1][j]:heightMap[row-1][j];
                int min = Math.min(rowmin, colmin);
                if(heightMap[i][j]<=min){
                    sum+=min-heightMap[i][j];
                    heightMap[i][j] =  min;
                }else{
                    heightMap[i][j-1] = Math.max(heightMap[i][j], heightMap[i][j-1]);
                    heightMap[i-1][j] = Math.max(heightMap[i][j], heightMap[i-1][j]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(twoPointerTrap(arr));
        int[][] dirarr = {
                {5,5,5,1},{5,1,1,5},{5,1,5,5},{5,2,5,8}};

        System.out.println(twoPointerTrapWithGraph(dirarr));
    }
}
