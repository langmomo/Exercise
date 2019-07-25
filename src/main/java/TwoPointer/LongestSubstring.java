package TwoPointer;
//340
public class LongestSubstring {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int[] arr = new int[256];
        int size = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(arr[s.charAt(i)]==0){
                size++;
            }
            arr[s.charAt(i)]++;
            while(size>k){
                if(--arr[s.charAt(start++)]==0) size--;
            }
            max = Math.max(max, i-start+1);
        }
        return max;
    }

    public static void main(String[] args){
        String s = "eceba";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
