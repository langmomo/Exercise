package Util;

public class BinarySearch {

    public static void binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        //在while里处理==的情况 while(start<=end)
        while(start<=end){
            int mid = (end-start)/2+start;
            System.out.println(arr[mid]);
            if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{

                System.out.println("find");
                return;
            }
        }
    }

    public static void findPivot(int[] arr){
        //pivot
        int start = 0;
        int end = arr.length-1;
        //在while里没有处理== 的情况， while（start<end）
        while(start<end){

            int mid = (end-start)/2+start;
            System.out.println(arr[mid]);
            if(arr[mid]<arr[end]){
                //order find here
                end = mid;

            }else if(arr[mid]>arr[end]) {
                //order find herefindPivot
                start = mid+1;
            }
        }
        System.out.println("pivot:" + arr[start]);
    }

    public static void main(String[] args){
        //even number
        int[] arr1 = {1,2,3,4,5};
        binarysearch(arr1, 4);
        //odd number
        int[] arr2 = {1,2,3,4,5,6};
        binarysearch(arr2, 5);
        int[] arr3 = {3,4,5,1,2};
        findPivot(arr3);
        int[] arr4 = {3,4,5,6,1,2};
        findPivot(arr4);
        int[] arr5 = {3,4,1,2};
        findPivot(arr4);
    }
}
