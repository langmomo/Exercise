package Graph;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {

    //leetcode

    //for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
    //DAG  directed acyclic graph

    public static boolean courseSchedule(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            HashSet<Integer> set = graph.getOrDefault(prerequisites[i][1], new HashSet<>());
            set.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], set);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int j=0; j<numCourses; j++){
            if(indegree[j]==0){
                q.offer(j);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            HashSet<Integer> set = graph.getOrDefault(cur, new HashSet<>());
            for(Integer curInt: set){
                indegree[curInt]-=1;
                //push to queue
                if(indegree[curInt] ==0){
                    q.offer(curInt);
                }
            }
        }
        for(int j=0; j<numCourses; j++){
            if(indegree[j]!=0){
                return false;
            }
        }
        return true;

    }

    public void generate(int number, int[][] edges){
        //generate graph
            int[] indegree = new int[number+1];
            HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
            for(int i=0; i<edges.length; i++){
                HashSet<Integer> set = new HashSet<>();
                for(int j=0; j<edges[i].length; j++){
                    set.add(edges[i][j]);
                    indegree[edges[i][j]]++;
                }
                graph.put(i, set);
            }
            //step1. find in_degree is 0 as entry point
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<number; i++){
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
            List<Integer> re =new ArrayList<>();
            while(!q.isEmpty()){
                int cur = q.poll();
                re.add(cur);
                HashSet<Integer> set = graph.get(cur);
                for(Integer curInt: set){
                    indegree[curInt]-=1;
                    //push to queue
                    if(indegree[curInt] ==0){
                        q.offer(curInt);
                    }
                }
            }
            String str = String.join(",", re.stream().map(item->String.valueOf(item)).collect(Collectors.toList()));
            System.out.println(str);

    }

    public static void main(String[] args){
        int[][] edges = {{},{},{3},{1},{0,1},{0,2}};
        TopologicalSort sort= new TopologicalSort();
        sort.generate(6, edges);

    }


}
