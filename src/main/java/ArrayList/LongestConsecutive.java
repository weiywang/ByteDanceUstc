package main.java.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int pre, after, max = 0;
        for(int num : nums){
            if(set.contains(num)){
                int temp = 1;
                set.remove(num);

                pre = num;
                after = num;
                while(set.contains(--pre)){
                    temp++;
                    set.remove(pre);
                }
                while(set.contains(++after)){
                    temp++;
                    set.remove(after);
                }

                max = Math.max(max, temp);

                //如果有一半以上的数字都在当前连续子序列里，则不可能有（大于该长度且不包含在当前连续序列）的子序列
                if(max > nums.length / 2){
                    return max;
                }
            }
        }
        return max;
    }

    public static void main(String[] Args){
        int[] nums = {100, 4, 200, 1, 3, 2, 5};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }
}
