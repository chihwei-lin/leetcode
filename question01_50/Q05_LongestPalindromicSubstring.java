package question01_50;

public class Q05_LongestPalindromicSubstring {
    private int start;
    private int maxLen;

    public String longestPalindrome(String s){
        for(int i=1;i<s.length();i++){
            // 假设长度为单数
            expandAroundCenter(s, i, i);
            // 假设长度为双数
            expandAroundCenter(s, i, i+1);
        }

        return s.substring(start, start + maxLen);
    }

    private void expandAroundCenter(String s, int left, int right){
        // 判定 1. 是否在界限內 2. left 和 right 指向的字元是否相同
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            // 判断是否大于 maxLen
            if(right - left + 1 > this.maxLen){     // 更新 maxLen 和 start
                this.maxLen = right - left + 1;
                this.start = left;
            }
            left--;
            right++;
        }
    }
}
