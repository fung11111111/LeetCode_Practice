package array;

import java.util.Arrays;

//leetcode 27
//faster than 100%
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            return nums[0] != val ? 1 : 0;
        }

        while (left < right) {
            if (nums[left] == val) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    nums[right] = val;
                    left++;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        if (left == right && nums[left] != val) {
            left++;
        }


        return left;
    }

    public void client() {

        int[] nums = new int[]{3};
        System.out.println(removeElement(nums, 5));
        Arrays.stream(nums)
                .forEach(System.out::println);
    }
}
