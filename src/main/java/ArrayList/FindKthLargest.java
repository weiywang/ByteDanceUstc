package main.java.ArrayList;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        fastSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void fastSort(int[] nums, int start, int end){
        if(nums.length < 1){
            return;
        }

        if(start > end){
            return;
        }
        if(start < 0 || end < 0 || start > nums.length - 1 || end > nums.length - 1){
            return;
        }

        int left = start;
        int right = end;
        int index = (left + right) / 2;

        while (left < right){
            while(right > index && nums[right] > nums[index]){
                right--;
            }
            if(index < right){
                swap(nums, index, right);
                index = right;
            }
            while(left < index && nums[left] < nums[index]){
                left++;
            }
            if(left < index){
                swap(nums, index, left);
                index = left;
            }
            left++;
        }
        fastSort(nums, start, index - 1);
        fastSort(nums, index + 1, end);
    }

    public static void swap(int[] nums, int indexA, int indexB){
        int temp =  nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

    public static void main(String[] Args){
        int[] nums = {3,2,1,5,6,4};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }
}
