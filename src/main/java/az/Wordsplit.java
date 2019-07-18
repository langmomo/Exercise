package az;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Note:
//
//        The same word in the dictionary may be reused multiple times in the segmentation.
//        You may assume the dictionary does not contain duplicate words.
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet", "code"]
//        Output: true
//        Explanation: Return true because
//        "leetcode"
//        can be segmented as
//        "leet code"
//        .
//        Example 2:
//
//        Input: s = "applepenapple", wordDict = ["apple", "pen"]
//        Output: true
//        Explanation: Return true because
//        "
//        applepenapple
//        "
//        can be segmented as
//        "
//        apple pen apple
//        "
public class Wordsplit {
    List<String> result = new ArrayList<>();
    public boolean helper(List<String> words, String s){
        if(s.length()==0){
            return true;
        }
        for(int i=0; i<words.size(); i++){
            if(s.startsWith(words.get(i))){

                if(helper(words, s.substring(words.get(i).length()))){
                    return true;
                }
            }
        }
        return false;
    }


        public String wordBreak(String s, Set<String> dict) {
            if (s == null || s.isEmpty() || dict == null) {
                return "";
            }

            boolean[] dp = new boolean[s.length() + 1];
            String[] words = new String[s.length() + 1];
            dp[0] = true;
            words[0] = "";

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        if (words[j].isEmpty()) {
                            words[i] = s.substring(j, i);
                        } else {
                            words[i] = words[j] + " " + s.substring(j, i);
                        }
                    }
                }
            }
            if (dp[s.length()]) {
                return words[s.length()];
            } else {
                return "";
            }
        }

    public static void main(String[] args){
        String s = "applepenappenle";
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("pen");
        Wordsplit w = new Wordsplit();
        boolean r = w.helper(words, s);
        System.out.println(r);
    }
}
