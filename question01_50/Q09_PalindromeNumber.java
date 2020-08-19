package question01_50;

/**
 * 9. Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * 解法：
 * 将数字倒反，比较两个数字是否相同
 */

public class Q09_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int digit = (int) (Math.log(x) / Math.log(10) + 1);     // 计算位数
        int reverse = 0;        // 存储倒反数字
        int num = x;

        for (int i = digit; i > 0; i--) {
            int dividend = num  / (int) Math.pow(10, i-1);
            num = num % (int) Math.pow(10, i-1);
            reverse = reverse + dividend * (int) Math.pow(10, (digit - i));
        }

        // 比较 x 和 num
        if (x == reverse)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));

        x = -121;
        System.out.println(isPalindrome(x));

        x = 10;
        System.out.println(isPalindrome(x));
    }
}
