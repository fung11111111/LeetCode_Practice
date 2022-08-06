package array;


import java.util.Arrays;

//leetcode 75
//faster than 100%
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == 2) {
                if (nums[right] != 2) {
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = tmp;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        left = 0;


        while (left < right) {
            if (nums[left] == 0) {
                left++;
            } else {
                if (nums[right] == 0) {
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = tmp;
                    left++;
                } else {
                    right--;
                }
            }
        }

    }

    public void client() {
        int[] nums = new int[]{0, 1, 2, 2, 1, 0, 1, 2, 0};
        sortColors(nums);
    }

}
