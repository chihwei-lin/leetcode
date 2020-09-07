package question01_50;

public class Q50_Pow{
    public double myPow(double x, int n) {
        // 边界问题
        if(x == 0.0)    return 0.0;
        if(n == 0)      return 1;
        if(n == 1)      return x;

        double divider = x;
        if(n < 0){
            while(n < 0){
                x /= divider;
                n++;
            }
        }else{
            while(n > 1){
                x *= divider;
                n--;
            }
        }

        return x;
    }
}
