package quesetion51_100;

import java.util.ArrayList;
import java.util.List;

public class Q56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // 边界问题
        if(intervals == null || intervals.length == 0)  return new int[][]{};
        if(intervals.length == 1)   return intervals;

        List<int[]> list = new ArrayList<>();

        int left = intervals[0][0], right = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int e1 = intervals[i][0], e2 = intervals[i][1];
            if(e1 <= right){
                right = Math.max(e2, right);
            }else{
                list.add(new int[]{left, right});
                left = e1;
                right = e2;
            }
        }

        int[][] result = new int[list.size()][2];
        int i=0;
        for(int[] element : list){
            result[i++] = element;
        }

        return result;
    }
}
