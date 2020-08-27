package question01_50;

import java.util.HashMap;

public class Q38_CountAndSay {
    public static String countAndSay(int n) {
        // 边界问题
        if(n == 0)  return "";

        String str = "1";

        // 计算 string 里每个数字的频率
        for (int i = 1; i < n; i++) {
            String tmp = "";
            for(int j = 0;j<str.length();){
                char c = str.charAt(j);
                int original_index = j;         // 存储原有的索引位置

                // 计算特定字符的出现频率
                while(j < str.length() && str.charAt(j) == c)   // 移动到不重复的字符索引上
                    j++;

                tmp += (j - original_index);
                tmp += c;

            }
            str = tmp;
        }
        return str;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countAndSay(n));

        n = 4;
        System.out.println(countAndSay(n));

        n = 5;
        System.out.println(countAndSay(n));
    }
}
