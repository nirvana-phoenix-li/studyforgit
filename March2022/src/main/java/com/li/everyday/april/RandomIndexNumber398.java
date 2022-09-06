package com.li.everyday.april;

import java.util.*;

/**
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * 通过次数35,305提交次数48,840
 */

public class RandomIndexNumber398 {
   private Map<String, List<Integer>> hashmap = new HashMap<String, List<Integer>>();
    public RandomIndexNumber398(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            String value = String.valueOf(nums[i]);
            if (!hashmap.containsKey(value)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashmap.put(value,list);
            }else {
                hashmap.get(value).add(i);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = hashmap.get(String.valueOf(target));
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }
}
