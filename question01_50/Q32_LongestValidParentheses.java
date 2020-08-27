package question01_50;

import java.util.Stack;

public class Q32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();

        // 边界问题
        if(n == 0 || n == 1)
            return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for(int i=0;i<n;i++){
            int c = s.charAt(i);
            int top = stack.peek();
            if(top == -1 || (s.charAt(top) == '(' && c == ')')){
                stack.pop();
                int newTop = stack.peek();
                max = Math.max(i-newTop, max);
            }else{
                stack.push(i);
            }
        }

        return max;
    }
}
