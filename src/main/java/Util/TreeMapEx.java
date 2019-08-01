package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TreeMapEx {

    public void helper(int[][] arr){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<arr.length; i++){
            for(int j=arr[i][0]; j<arr[i][1]; j++){
                int num = map.getOrDefault(j, 0);
                num = num>=arr[i][2]?num:arr[i][2];
                map.put(j, num);
            }
            int num = map.getOrDefault(arr[i][1], 0);

            map.put(arr[i][1], num);
        }
        int prev = -1;
        List<List<Integer>> re = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key)!=prev){
                re.add(Arrays.asList(key, map.get(key)));
                System.out.println(key+" "+map.get(key));
                prev = map.get(key);
            }
        }


    }

    public static void main(String[] args){
        int[][] arr= {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        TreeMapEx t = new TreeMapEx();
        t.helper(arr);
    }
}
