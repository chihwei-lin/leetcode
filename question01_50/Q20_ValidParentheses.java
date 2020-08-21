package question01_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 检查字符串是否具有正确的括号
 *
 * 1：排除非括号的字符
 * 2：初始一个 Stack
 * 3：开括号加入到 Stack
 * 4：闭括号则调用 remove 方法
 * 5：最后检查 Stack 是否为空
 *
 */

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        // 边界问题
        if(s.length() == 0) return true;
        else if(s.length() < 2)  return false;

        // 栈用于存储括号，Map 用于存储对应的开闭括号
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // 遍历字符串 s
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.add(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty())     return false;
                char bracket = stack.pop();
                if(bracket != map.get(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
