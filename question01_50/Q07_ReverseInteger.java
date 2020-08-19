package question01_50;

public class Q07_ReverseInteger {
    public static int myAtoi(String str) {
        int sign = 1;
        int sum = 0;
        boolean hasSign = false;

        for (int i = 0; i < str.length(); i++) {
            // 空白
            if(str.charAt(i) == ' ' && !hasSign)
                continue;
            if(!hasSign && str.charAt(i) == '-'){
                sign = -1;
                hasSign = true;
                continue;
            }else if(!hasSign && str.charAt(i) == '+'){
                sign = 1;
                hasSign = true;
                continue;
            }else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                hasSign = true;

                if(sum * sign > Integer.MAX_VALUE / 10 || (sum * sign == Integer.MAX_VALUE / 10 && (str.charAt(i)-'0') * sign > 7))
                    return Integer.MAX_VALUE;
                else if(sum * sign < Integer.MIN_VALUE / 10 || (sum * sign == Integer.MIN_VALUE / 10 && (str.charAt(i)-'0') * sign < -8))
                    return Integer.MIN_VALUE;
                sum = sum * 10 + (str.charAt(i) - '0');
            }else{
                return sum * sign;
            }
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        String input = "42";
        System.out.println(myAtoi(input));

        input = "   -42";
        System.out.println(myAtoi(input));

        input = "4193 with words";
        System.out.println(myAtoi(input));

        input = "words and 987";
        System.out.println(myAtoi(input));

        input = "-91283472332";
        System.out.println(myAtoi(input));

        input = "   +0 123";
        System.out.println(myAtoi(input));

        input = "2147483648";
        System.out.println(myAtoi(input));
    }
}
