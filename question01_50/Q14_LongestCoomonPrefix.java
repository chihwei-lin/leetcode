package question01_50;

public class Q14_LongestCoomonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        boolean run = true;
        int minLen = strs[0].length();
        StringBuilder str = new StringBuilder();

        // 取得所有字符串中最短长度
        for(int i=1;i<strs.length;i++)
            minLen = Math.min(minLen, strs[i].length());

        // 遍历在最短长度内的字符
        int i = 0;
        while(run && i < minLen){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i) != c){     // 终止当前遍历 并将 run 赋值 false（终止父遍历）
                    run = false;
                    break;
                }
            }
            if(run)
                str.append(c);
            i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));
    }
}
