package Util;

import java.util.*;

// use priority Queue
public class Overlapping {

    //meeting room
    public static void meetingRoom(int[][] arr){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // arr is sorted by it's start time
        for(int i=0; i<arr.length; i++){
            if(!q.isEmpty()){
                int[] curr = q.poll();
                if(curr[1]>arr[i][0]){

                    q.offer(arr[i]);
                    q.offer(curr);
                }else{
                    curr[1] = arr[i][1];
                    q.offer(curr);
                }
            }else{

                q.offer(arr[i]);
            }

        }
        System.out.println(q.size());

    }

    public static void skyLine(int[][] buildings){
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }

    }



    public static void main(String[] args){
        int[][] arr = {{0, 30},{5, 10},{15, 20}};
        //int[][] arr= {{1,5},{2,3},{4,8},{9,10},{9,11}};
        //meetingRoom(arr);
        //[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        int[][] skyline = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        skyLine(skyline);

    }
}
