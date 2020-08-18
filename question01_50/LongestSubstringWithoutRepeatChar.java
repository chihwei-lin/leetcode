package question01_50;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * 1. define boolean[128] to store character position
 * 2. 索引是字元，值是字元的索引
 * 3. 如果
 */

public class LongestSubstringWithoutRepeatChar {
    public static int lengthOfLongestSubstring(String s) {      // 2ms, faster than 99.86%
        if(s.length()==1)
            return 1;

        int sum=0;
        int left = 0, right = 0;
        boolean[] used = new boolean[128];

        while(right < s.length()){
            if(used[s.charAt(right)] == false){
                used[s.charAt(right)] = true;
                right++;
            }else{
                sum = Math.max(sum, right-left);
                while(left<right && s.charAt(right) != s.charAt(left)){
                    used[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        sum = Math.max(sum, right - left);

        return sum;
    }

    public static int lengthOfLongestSubstring2(String s) {         // 108ms faster than 12.33%, 39.7MB, less than 71.12%
        if(s.length()==1)
            return 1;

        int sum = 0;

        Map<Character, Integer> map = new HashMap<>();
        int i=0;

        while(i<s.length()){
            char c = s.charAt(i);

            // map exists char c
            if(map.containsKey(c)){
                if(map.keySet().size() > sum)       // replace sum
                    sum = map.keySet().size();
                i = map.get(c);
                map = new HashMap<>();              // clear map
            }
            // map doesn't exist char c
            else
                map.put(c, i);
            i++;
        }

        if(map.keySet().size() > sum)
            return map.keySet().size();
        return sum;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input));

        input = "bbbbb";
        System.out.println(lengthOfLongestSubstring(input));

        input = "pwwkew";
        System.out.println(lengthOfLongestSubstring(input));

        input = "";
        System.out.println(lengthOfLongestSubstring(input));

        input = " ";
        System.out.println(lengthOfLongestSubstring(input));

        input = "au";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
