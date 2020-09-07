package quesetion51_100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 将数组分为两部分作处理，
 */

public class Q57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 边界问题
        if(intervals == null || intervals.length == 0)  return new int[][]{newInterval};

        List<int[]> list = new ArrayList<>();

        if(newInterval[0] < intervals[0][0]){
            list.add(newInterval);
        }

        // 过滤所有小于 newInterval 的 interval
        int i = 0;
        int e1, e2;

        while(i < intervals.length){
            e1 = intervals[i][0];
            e2 = intervals[i][1];

            if(e2 < newInterval[0])
                list.add(intervals[i]);
            else
                break;
            i++;
        }

        // 检查是否到最后一个区间
        if(i == intervals.length)
            list.add(newInterval);
        else{
            int left = Math.min(intervals[i][0], newInterval[0]);
            int right = Math.max(intervals[i][1], newInterval[1]);
            i++;

            //处理后半部分
            while(i < intervals.length){
                e1 = intervals[i][0];
                e2 = intervals[i][1];

                if(e1 <= right){
                    right = Math.max(e2, right);
                }else{
                    list.add(new int[]{left, right});
                    left = e1;
                    right = e2;
                }
                i++;
            }

            list.add(new int[]{left, right});
        }

        int[][] result = new int[list.size()][2];       // 返回最终答案

        i = 0;
        for(int[] element:list)                         // 转化成输出格式
            result[i++] = element;

        return result;
    }
}
