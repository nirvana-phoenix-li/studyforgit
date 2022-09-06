package com.li.everyday.april;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * <p>
 * 返回满足此条件的 任一数组 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 * 通过次数81,154提交次数114,504
 */
public class SortArrayByParity905 {

    public int[] sortArrayByParity(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            while ((nums[left] & 1) == 0 && left < right) {
                left++;
            }
            while ((nums[right] & 1) == 1 && left < right) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity905 main = new SortArrayByParity905();
        int[] ints = main.sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println(Arrays.toString(ints));
    }
}
