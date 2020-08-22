package question01_50;

public class Q28_ImplementStr {
    public int strStr(String haystack, String needle) {
        // 边界问题
        if(needle.equals(""))  return 0;
        if(haystack.equals(""))    return -1;

        int pointer1 = 0, pointer2 = 0;

        int n = haystack.length();
        int m = needle.length();
        while(pointer1 < n){
            if(pointer2 < m && haystack.charAt(pointer1) == needle.charAt(pointer2)){
                pointer1++;
                pointer2++;
                if(pointer2 == m){
                    return pointer1 - pointer2;
                }
            }
            else{
                pointer1 = pointer1 - pointer2 + 1;
                pointer2 = 0;
            }
        }
        return -1;
    }
}
