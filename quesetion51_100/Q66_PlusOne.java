package quesetion51_100;

public class Q66_PlusOne {
    public int[] plusOne(int[] digits) {
        // 边界问题
        if(digits == null || digits.length == 0)   return new int[]{0};

        if(digits.length == 1 && digits[0] != 9)    return new int[]{digits[0]+1};
        if(digits.length == 1 && digits[0] == 9)    return new int[]{1, 0};

        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] arr = new int[n+1];
        arr[0] = 1;

        return arr;
    }
}
