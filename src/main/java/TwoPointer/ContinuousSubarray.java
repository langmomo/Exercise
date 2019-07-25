package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinuousSubarray {

    public static void helper(int[] arr, int M){
        int start = 0;
        int max = 0;
        int curr = 0;
        int[] re = new int[2];
        for(int i=0; i<arr.length; i++){
            curr+=arr[i];
            while(curr>M){
                curr-=arr[start++];
            }
            if(max<curr){
                max = curr;
                re[0] = start;
                re[1] = i;
            }
        }
        System.out.println(re[0]+" "+ re[1]);
    }

    public static void containerWithMostWater(int[] height){
        //left<right factor: range(x,y) * min(height[start], height[end])
        int start = 0;
        int end = height.length-1;
        int max = 0;
        while(start<end){

            if(height[start]<height[end]){
                max = Math.max(height[start]*(end-start+1), max);
                start++;
            }else{
                max = Math.max(height[end]*(end-start+1), max);
                end--;
            }
        }


    }
    //LC
    public static void substringwithConcatenationofAllWords(String s, String[] words){
        // words=> 定长 是否找到可能结果，用dfs（只需要找一个）
        int length = 0;
        boolean[] visited = new boolean[words.length];

        List<Integer> re = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            length+=words[i].length();
        }
        for(int i=0; (i+length)<s.length();i++){
            if(find(i, i+length, s,words, visited)){
                re.add(i);
            }
            Arrays.fill(visited, false);
        }

        re.forEach(i->System.out.println(i));

    }

    public static boolean find(int start, int end, String s, String[] words, boolean[] visited){
        if(start==end) return true;
        String curr = s.substring(start, end);
        for(int i=0; i<words.length; i++){
            if(!visited[i] && curr.startsWith(words[i])){
                visited[i] = true;
                if(find(start+words[i].length(), end, s, words, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void longestSubstringWithoutRepeatingCharacters(String s){
        int[] arr = new int[256];
        int start = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)]++;
            while(arr[s.charAt(i)]>1){
                arr[s.charAt(start++)]--;
            }
            max = Math.max(max, i-start+1);
        }
    }

    public static void main(String[] args){
        //Given an array having N positive integers,
        // find the contiguous subarray having sum as great as possible,,
        // but not greater than M.

        //1. constraint -- not greater than M
//
//        int[] arr = {1,5,2,3,4,6};
//        int M = 7;
//        helper(arr, M);

        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        substringwithConcatenationofAllWords(s, words);

    }
}
