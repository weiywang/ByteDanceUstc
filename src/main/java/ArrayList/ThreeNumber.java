package main.java.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumber {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums.length == 0 || nums[0] > 0 || nums[nums.length-1] < 0) return result;
        for(int k = 0;k < nums.length;++k){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int target = 0 - nums[k];
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                if(nums[i] + nums[j] == target){
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[i+1]) ++i;
                    while(i < j && nums[j] == nums[j-1]) --j;
                    ++i; --j;
                }
                else if(nums[i] + nums[j] < target) ++i;
                else --j;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}
