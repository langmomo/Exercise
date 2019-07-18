package Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateGraph {

    public boolean checkOdd(int[][] edges, int[] vertex, int flag){
        // odd edges in graph bfs
        Stack<Integer> stack = new Stack<>();
        List<Integer> vList = Arrays.stream(vertex).boxed().collect(Collectors.toList());

        while(vList.contains(0)){
            int ind = vList.indexOf(0);
            stack.push(ind);
            vList.set(ind, flag);
            while(!stack.isEmpty()){
                flag = -flag;
                int size = stack.size();
                for(int i=0; i<size; i++){
                    int cur = stack.pop();
                    for(int v: edges[cur]){
                        if(vertex[v]!=0 && vertex[v]!= flag){
                            return false;
                        }else{
                            vertex[v] = flag;
                            if(!stack.contains(v)) stack.push(v);
                        }
                    }

                }

            }
        }

        return true;

    }

    public static void main(String[] args){
        //generate graph
        GenerateGraph g = new GenerateGraph();
        int[][] edges = {{1,2,3,4},{0},{0,6},{0,5},{0,5},{3,4,6},{2,5}};
        int[] vertex = new int[edges.length];
        boolean re = g.checkOdd(edges, vertex, 1);
        System.out.println(re);


    }
}
