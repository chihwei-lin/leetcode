package question01_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * 1. 按照 Z 形走
 * 2. 向下走直到底
 * 3. 向斜走直到最上
 *
 */

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        StringBuilder[] stringList = new StringBuilder[numRows];    // 存储 Z 形字符串
        for (int i = 0; i < numRows; i++) {
            stringList[i] = new StringBuilder();
        }

        int i =0;
        while(i<s.length()){

            // 向下走
            int j = 0;
            while(i < s.length() && j < numRows){
                char c = s.charAt(i++);

                stringList[j++].append(c);
            }

            System.out.println(j);

            // 斜着走
            j = j - 2;
            while(i < s.length() && j > 0){
                char c = s.charAt(i++);

                stringList[j--].append(c);
            }
        }

        String ret = "";
        for(i=0;i<numRows;i++){
            ret += stringList[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numrows = 4;

        System.out.println(convert(s, numrows));
    }
}
