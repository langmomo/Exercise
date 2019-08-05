package Util;

public class DP {

    public static boolean regexExe(String str, String p){
        // abc a*b
        //1.  .mean any character dp[i][j] = dp[i-1][j-1]
        //* mean 0-n character
        // mean 0 dp[i][j] = dp[i][j-1] skip *
        // mean 1+ dp[i][j] = dp[i-1][j]
        boolean[][] dp = new boolean[str.length()+1][p.length()+1];
        //for(int i=0; i<str.length(); i++)dp[i][0] = true;
        dp[0][0] = true;
        for(int j=1; j<=p.length(); j++) {
            if (p.charAt(j-1) != '*')
                break;
            else
                dp[0][j] = true;
        }
        for(int i=0; i<str.length(); i++){

            for(int j=0; j<p.length(); j++){
                if(str.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j)=='*'){
                    dp[i+1][j+1] = dp[i+1][j]||dp[i][j+1];
                }
            }
        }
        return dp[str.length()][p.length()];
    }

    public static void main(String[] args){
        String str="adceb";
        String p = "*a*b";
        System.out.println(String.format("str: %s, p: %s, re:%s ",str, p, regexExe(str, p)));

    }
}
