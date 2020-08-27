package question01_50;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * 找出下一个比 initial permutation 大的组合
 * 如果没有 则回传最小的组合
 *
 */

public class Q31_NextPermutation {
    public static void nextPermutation(int[] nums) {
        // 边界问题
        if(nums.length == 0 || nums.length == 1)    return;

        // 找出倒序子序列
        int indexForSeqInDesc = nums.length-1;
        while(indexForSeqInDesc > 0 && nums[indexForSeqInDesc] <= nums[indexForSeqInDesc-1])
            indexForSeqInDesc--;

        System.out.println(indexForSeqInDesc);

        // 如果倒序子序列为初始组合 则对 nums 排序
        if(indexForSeqInDesc == 0){
            Arrays.sort(nums);
            return;
        }
        indexForSeqInDesc--;

        // 如果不是，找到比 nums[indexForSeqInDesc-1] 大的数字 进行交换
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > nums[indexForSeqInDesc]){
                int tmp = nums[i];
                nums[i] = nums[indexForSeqInDesc];
                nums[indexForSeqInDesc] = tmp;
                break;
            }
        }

        // 对 indexForSeqIndesc 到 nums.length - 1 进行排序
        for(int i=indexForSeqInDesc+1;i<nums.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] < nums[i])
                    minIndex = j;
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,2,1,5,4,3,0};
//        nextPermutation(nums);

        nums = new int[]{5,1,1};
        nextPermutation(nums);
    }
}
