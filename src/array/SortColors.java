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

        Arrays.stream(nums)
                .forEach(System.out::println);

    }

    public void sortColorsThreePointer(int[] nums) {
        if (nums.length == 1) return;

        int  start = 0, end = nums.length - 1, i = 0;

        while( start < end && i <= end ) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                i++; start++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                i++;
            }
        }
        Arrays.stream(nums)
                .forEach(System.out::println);

    }

    public void client() {
        int[] nums = new int[]{0, 1, 2, 2, 1, 0, 1, 2, 0};
        sortColors(nums);
    }

}
