package main.java.ArrayList;

public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int max = 1;
        int start = 0;
        int end = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                end = i;
                max = Math.max(max, (end - start + 1));
            }
            else {
                start = i;
            }
        }
        return max;
    }

    public static void main(String[] Args){
        int[] nums = {1,3,5,4,7};
        int res = findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
