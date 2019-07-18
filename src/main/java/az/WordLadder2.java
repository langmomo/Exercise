package az;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Problem:
//
//        Given two words (beginWord and endWord), and a dictionary’s word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//
//        Only one letter can be changed at a time
//        Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//        For example,
//
//        Given:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        Return
//
//        1
//        2
//        3
//        4
//        [
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        ]
//        Note:
//
//        Return an empty list if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWord are non-empty and are not the same.
//        Idea:
//
//        BFS to construct the graph + DFS to extract the paths
public class WordLadder2 {
    List<ArrayList<String>> finalResult = new ArrayList<>();
    public void solve(String begin, String end, ArrayList<String> list){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        generate(list, map);
        ArrayList<String> newlist = new ArrayList<>();
        newlist.add("hot");
        dfs("hot", end, newlist, map);
        Collections.sort(finalResult, (a, b)->a.size()-b.size());
        int minlength = finalResult.get(0).size();
        int i=0;
        for(i=0;i<finalResult.size(); i++){
            if(finalResult.get(i).size()>minlength){
                break;
            }
        }
        finalResult.subList(0, i).forEach(l->System.out.println(String.join(",", l)));
    }
    public void dfs(String key, String endword, ArrayList<String> result, HashMap<String, ArrayList<String>> map){

        if(key.equals(endword)){
            finalResult.add(new ArrayList<String>(result));
            return;
        }
        ArrayList<String> list = map.get(key);
        for(int i=0; i<list.size(); i++){
            if(result.contains(list.get(i))){
                continue;
            }
            result.add(list.get(i));
            dfs(list.get(i), endword, result, map);
            result.remove(result.size()-1);
        }
    }

    public void generate(ArrayList<String> list, HashMap<String, ArrayList<String>> map){
        for(int i=0; i<list.size(); i++){
            ArrayList<String> nextList = map.getOrDefault(list.get(i), new ArrayList<String>());

            for(int j=0; j<list.size();j++){
                if(list.get(j)==list.get(i) || nextList.contains(list.get(j))){
                    continue;
                }else{

                    if(isValid(list.get(j), list.get(i))){
                        nextList.add(list.get(j));
                        ArrayList<String> nextList2 = map.getOrDefault(list.get(j), new ArrayList<>());
                        nextList2.add(list.get(i));
                        map.put(list.get(j), nextList2);
                        map.put(list.get(i), nextList);
                    }
                }
            }
        }
    }

    public boolean isValid(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }else{
            int diff = 0;
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    diff++;
                }
                if(diff>1){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        WordLadder2 w2 = new WordLadder2();
        w2.solve("hit", "cog", list);


    }
}
