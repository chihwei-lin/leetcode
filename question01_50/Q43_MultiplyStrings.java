package question01_50;

/**
 * 43. Multiply Strings
 *
 * "123456789"
 * "987654321"
 */

public class Q43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        // 边界问题
        if(num1 == null || num2 == null)    return "0";
        if(num1 == "0" || num2 == "0")      return "0";

        int sum = 0;

        // 将 num2 作为主回圈
        for(int i=0;i<num2.length();i++){
            int num = num2.charAt(i)- '0';

            sum += (int) (calculate(num1, num) * Math.pow(10, num2.length()-i-1));
        }

        return sum + "";
    }

    private int calculate(String num1, int multiplier){
        int sum = 0;

        for(int i=0;i<num1.length();i++){
            int num = (num1.charAt(i) - '0') * multiplier;
            int carry = num / 10;
            int remainder = num % 10;

            sum = (sum + carry) * 10 + remainder;
        }

        return sum;
    }
}
