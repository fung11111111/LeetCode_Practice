package array;

import java.util.Arrays;


//leetcode 31
//todo: not yet finished
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int[] newArr = nums.clone();
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        Boolean isLeftLargest = false;
        int first = nums[0];
        int largest = first;
        int largestIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= largest) {
                largest = nums[i];
                largestIdx = i;
            }
        }
        if (largestIdx != 0) {
            int tmp = nums[largestIdx - 1];
            nums[largestIdx - 1] = largest;
            nums[largestIdx] = tmp;
        } else {

        }


    }

    public void client() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        nextPermutation(nums);
    }
}
