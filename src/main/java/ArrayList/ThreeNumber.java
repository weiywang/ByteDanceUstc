package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumber {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                for(int t = 0;t < j;t++) {
                    if (nums[i] + nums[j] + nums[t]== 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[t]));
                    }
                }
            }
        }
        return result;
    }
}
