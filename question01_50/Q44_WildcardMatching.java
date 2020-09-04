package question01_50;

import java.util.Arrays;

/**
 * s：字符串
 * p：规律
 *
 * ？：代表所有单个字符
 * *：代表所有字符序列（包括空序列）
 *
 * s = "aa", p = "a" -> false
 * s = "aa", p = "*" -> true
 * s = "cb", p = "?a" -> false
 * s = "adceb", p = "*a*b" -> true
 * s = "acdcb", p = "a*c?b" -> false
 */

public class Q44_WildcardMatching {
    public static boolean isMatch(String s, String p) {
        // 边界问题
        if((s == null && p == null) || (s == " " && p == " "))  return true;
        if(s == null || s == " " || p == null || p == " ")      return false;

        //  方法 1：动态规划
        s = " " + s;
        p = " " + p;

        int row = s.length(), col = p.length();
        boolean[][] dp = new boolean[row][col];
        dp[0][0] = true;

        //
        for(int i=1;i<row;i++)
            dp[i][0] = false;


        for(int j=1;j<col;j++){
            if(p.charAt(j) == '*')
                dp[0][j] = dp[0][j-1];
            else
                dp[0][j] = false;
        }

        // 遍历 s 和 p 字符串
        for (int i = 1; i < row; i++) {
            char s_char = s.charAt(i);
            for (int j = 1; j < col; j++) {
                char p_char = p.charAt(j);

                if(s_char == p_char || p_char == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p_char == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j] = false;
            }
        }

//        for(int i=0;i<row;i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
//        isMatch("aab", "c*a*b");
        System.out.println(isMatch("ho", "**ho"));
    }
}
