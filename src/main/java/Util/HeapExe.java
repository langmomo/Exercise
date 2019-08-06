package Util;

import java.util.PriorityQueue;

//Priority Queue 自动排序---> 目前是无序的，目标是有序的
//按给定顺序入Q, 每次拿Q.peek() 好处是不用每次sort
//典型用法是第K个最大元素
public class HeapExe {
    int N;
    boolean first= false;
    boolean last = false;
    class Seat{
        int start = 0;
        int end = 0;
        int interval = 0;
        Seat(int start, int end){
            this.start = start;
            this.end = end;

            this.interval = (end-start)/2;


        }
    }
    PriorityQueue<Seat> pq;
    public void examseat(int n){
        N =n;
        pq = new PriorityQueue<>();
        pq.offer(new Seat(0, n));
    }

    public int seat(){
        if(!first){
            first = true;
            return 1;
        }else if(!last){
            last = true;
            return N;
        }else{
            Seat avail = pq.poll();
            int curr = (avail.end-avail.start)/2+avail.start;
            pq.offer(new Seat(avail.start, curr));
            pq.offer(new Seat(curr, avail.end));
            return curr;
        }
    }

    public void leave(int n){
        Seat pre = null;
        Seat next = null;
        for(Seat s: pq){
            if(s.start == n){
                next = s;
            }else if (s.end ==n){
                pre = s;
            }
        }
        if(next!=null && pre!=null){
            pq.remove(next);
            pq.remove(pre);
            pq.offer(new Seat(pre.start, next.end));
        }
    }


}
