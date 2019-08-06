package Util;

public class Palindorm {

    public static boolean isPalindorm(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
        }
        return true;
    }
}
