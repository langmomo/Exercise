package data;

public class e1 {
    static int max = 0;
    public static void main(String[] args){
        int[] a = {1,3,-3};
        solve(0, 2, a);
        System.out.println(max);
    }

    public static void solve(int start, int end, int[] a){
        while(start<end){
            int total = a[start]+a[end]+ end-start;
            max = Math.max(total, max);
            if(a[start] > a[end]){
                end--;
            }else{
                start ++;
            }
        }

    }
}
