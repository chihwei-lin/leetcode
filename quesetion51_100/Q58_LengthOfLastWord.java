package quesetion51_100;

/**
 * 58. Length of Last Word
 *
 */

public class Q58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // 边界问题
        if(s == null || s.length() == 0)    return 0;

        // 过滤最后面的空白
        int start = s.length()-1;
        while(start >= 0 && s.charAt(start) == ' ')
            start--;

        int len = 0;

        int i = start;
        while(i >= 0 && s.charAt(i) != ' '){
            i--;
            len++;
        }
        return len;
    }
}
