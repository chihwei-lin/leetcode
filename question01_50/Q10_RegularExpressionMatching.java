package question01_50;

import java.util.Arrays;

/**
 * 10. Regular Expression Matching
 *
 * 解法：动态规划
 */

public class Q10_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        s = " " + s;
        p = " " + p;

        // 设定 s 为行，p 为列
        boolean[][] dp = new boolean[m+1][n+1];

        // 初始化 row = 0，col = 0
        dp[0][0] = true;
        for(int i=1;i<=m;i++)
            dp[i][0] = false;
        for(int j=1;j<=n;j++){
            char c = p.charAt(j);
            if(c == '*')
                dp[0][j] = dp[0][j-2];
            else
                dp[0][j] = false;
        }

        for (int i = 1; i <=m; i++) {
            for(int j=1; j<=n; j++){
                // p[j] == s[i] or p[j] == '.'
                if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
                    dp[i][j] = dp[i-1][j-1];

                // p[j] != s[i]
                else if(p.charAt(j) == '*'){
                    if(dp[i][j-2])
                        dp[i][j] = dp[i][j-2];
                    else if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.')
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = false;
                }
            }

        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(isMatch(s, p));

        s = "aa";
        p = "a*";
        System.out.println(isMatch(s, p));

        s = "ab";
        p = ".*";
        System.out.println(isMatch(s, p));

        s = "aab";
        p = "c*a*b";
        System.out.println(isMatch(s, p));

        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println(isMatch(s, p));
    }

    private static void printArray(boolean[][] dp){
        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
