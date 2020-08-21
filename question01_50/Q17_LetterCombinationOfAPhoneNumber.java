package question01_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q17_LetterCombinationOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){        // 当前元素长度不等于 digits 长度
            String remove = ans.remove();                   // 获得并删除当前元素
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(Arrays.toString(letterCombinations(digits).toArray()));
    }
}
