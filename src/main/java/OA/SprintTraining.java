package OA;

public class SprintTraining {

    public static void solve(int number, int[] num){
        int[] arr = new int[number+1];
        for(int i=0; i<num.length-1; i++){
            int start = Math.min(num[i], num[i + 1]);
            int end = Math.max(num[i], num[i + 1]);
            arr[start]++;
            arr[end + 1]--;
        }
        int max = arr[0];
        int ind = 0;
        for(int i=1; i<arr.length; i++){
            arr[i] += arr[i-1];
            if(arr[i]>max){
                ind = i;
                max = arr[i];
            }
        }
        System.out.println(String.format("max ind %s", ind));
    }

    public static void main(String[] args){
        solve(5, new int[]{2,4,1,3});

    }
}
