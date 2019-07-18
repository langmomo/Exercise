package az;
//Given a non-empty list of words, return the k most frequent elements.
//
//        Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
//
//        Example 1:
//
//        Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//        Output: ["i", "love"]
//        Explanation: "i" and "love" are the two most frequent words.
//        Note that "i" comes before "love" due to a lower alphabetical order.
//
//
//        Example 2:
//
//        Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//        Output: ["the", "is", "sunny", "day"]
//        Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//        with the number of occurrence being 4, 3, 2 and 1 respectively.
//Note:
//
//        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//        Input words contain only lowercase letters.
//
//
//        Follow up:
//
//        Try to solve it in O(n log k) time and O(n) extra space.
//        Can you solve it in O(n) time with only O(k) extra space?

import java.util.*;

public class TopK {
    public void solve(ArrayList<String> list, int n){
        Map<String, Integer> count = new HashMap();
        for (String word: list) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1) != count.get(w2) ?
                count.get(w2) - count.get(w1) : w1.compareTo(w2));
        String output = String.join(",",candidates.subList(0, n));
        System.out.println(output);
    }

    public static void main(String[] args){
        ArrayList<String> l1 = new ArrayList<String>();
        l1.add("i");
        l1.add("love");
        l1.add("leetcode");
        l1.add("i");
        l1.add("love");
        l1.add("coding");
        TopK k = new TopK();
        k.solve(l1, 2);


    }
}
