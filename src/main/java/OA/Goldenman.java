package OA;

import java.util.*;

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
            len=Math.abs(len);
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


    public static String[] strangeSort(double[] mapping, String[] nums){
        HashMap<Double, Integer> map = new HashMap<>();
        for(int i=0; i<mapping.length; i++){
            map.put(mapping[i], i);
        }
        for(int i=0; i<nums.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<nums[i].length(); j++){
                sb.append(map.get(nums[i].charAt(j)));
            }
            String s = sb.toString();
            if(s.startsWith("0")) s = s.substring(1);
            nums[i] = s;
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


    public static int findTheRank(int[][] performace, int rank){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0; i<performace.length; i++){
            int sum = 0;
            for(int j=0; i<performace[i].length; j++){
                 sum+=performace[i][j];
            }
            pq.offer(new int[]{i, sum});

        }
        int[] curr = null;
        for(int i=1; i<rank; i++){
            curr = pq.poll();
        }
        return curr!=null?curr[0]:0;

    }

    public static int matrixGame(int[][] arr){
        int[] col = new int[arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                col[j] = Math.max(col[j], arr[i][j]);
            }
        }

        Arrays.sort(col);
        int a = 0;

        for(int i=0; i<col.length; i++){
            if(i%2==0){
                a+=col[i];
            }else{
                a-=col[i];
            }
        }
        return Math.abs(a);
    }

    public static List<Integer> spiralOrderPrimes(int[][] grid){
        int rowEnd = grid.length-1;
        int colEnd = grid[0].length-1;
        int rowStart = 0;
        int colStart = 0;
        List<Integer> list = new ArrayList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                if(isPrime(grid[rowStart][i])) list.add(grid[rowStart][i]);
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                if(isPrime(grid[i][colEnd])) list.add(grid[i][colEnd]);
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd && isPrime(grid[rowEnd][i]))
                    list.add(grid[rowEnd][i]);
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd && isPrime(grid[i][colStart]))
                    list.add(grid[i][colStart]);
            }
            colStart ++;
        }
        return list;
    }
    public static boolean isPrime(int num) {
        // 两个较小数另外处理
        if(num==1) return false;
        if (num == 2 || num == 3)
            return true;
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5)
            return false;
        int tmp = (int) Math.sqrt(num);
        // 在6的倍数两侧的也可能不是质数
        for (int i = 5; i <= tmp; i += 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        // 排除所有，剩余的是质数
        return true;
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
        System.out.println(rotateTheString("hurart",new int[]{0,1}, new int[]{4,2}));
        System.out.println(spiralOrderPrimes(new int[][]{{7,7,3,8,1},{13,5,4,5,2},{9,2,12,3,9},{6,12,1,11,41}}));
    }
}
