package DC;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Kth Largest Element in an Array
//        Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//        For example,
//        Given [3,2,1,5,6,4] and k = 2, return 5.
//
//        **Note: **
//        You may assume k is always valid, 1 ≤ k ≤ array's length.
//
//        Credits:
//        Special thanks to @mithmatt for adding this problem and creating all test cases.
public class Kvalue {
    //need to return position, we cannot sort the list. put item in a priority queue and return kth value
    public void solve(List<Integer> list, int k){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0; i<list.size(); i++){
            int[] item = new int[]{list.get(i), i};
            queue.add(item);
        }

        for(int i=0; i<k-1; i++){
            queue.poll();
        }
        System.out.println(queue.poll()[0]);
    }

    public static void main(String[] args){
        Kvalue k = new Kvalue();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(4);
        k.solve(list, 2);
    }
}
