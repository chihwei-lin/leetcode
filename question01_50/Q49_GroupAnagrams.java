package question01_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams
 *
 *
 */

public class Q49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs == null || strs.length == 0)    return result;

        HashMap<String, List<String>> map = new HashMap<>();

        // 遍历字符串数组
        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sorted_s = String.valueOf(charArr);

            if(map.containsKey(sorted_s)){
                List<String> list = map.get(sorted_s);
                list.add(s);
                map.replace(sorted_s, list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted_s, list);
            }
        }

        // 遍历 map 里的值，并转化成 List of List 形式
        for(List<String> strings : map.values()){
            result.add(strings);
        }

        return result;
    }
}
