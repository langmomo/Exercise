package Util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort {

    public int[] mergeSort(int[] arr){
        if(arr.length==1) return arr;
        int start = 0;
        int end = arr.length;
        int mid = (end-start)/2+start;
        int[] l1 = mergeSort(Arrays.copyOfRange(arr, start, mid));
        int[] l2 = mergeSort(Arrays.copyOfRange(arr, mid, end));
        int[] re = merge(l1, l2);
        return re;
    }

    public int[] merge(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        int s1 = 0;
        int s2 = 0;
        int ind = 0;
        while(s1<arr1.length && s2<arr2.length){
            if(arr1[s1]<arr2[s2]){

                arr[ind++] = arr1[s1];
                s1++;
            }else{
                arr[ind++] = arr2[s2];
                s2++;
            }
        }
        while (s1<arr1.length){
            arr[ind++] = arr1[s1++];
        }

        while(s2<arr2.length){
            arr[ind++] = arr2[s2++];
        }
        return arr;
    }


    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // find the first large ind as i
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void main(String[] args){
        Sort s = new Sort();
        int[] arr = {1,4,2,5,3};
        int[] re = s.mergeSort(arr);
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.stream(re).boxed().collect(Collectors.toList()));
        s.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
