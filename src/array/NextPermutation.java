package array;

import java.util.Arrays;


//leetcode 31
//todo: not yet finished
public class NextPermutation {
    public void nextPermutation(int[] nums) {

        int highestIndex = 0;
        int pivotIndex = 0;
        int swapIndex = 0;

        // find the pivot index, i starting from the last number but 1 number, i+1 would be the last number for the 1st iteration
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                highestIndex = i + 1;
                pivotIndex = highestIndex - 1;
                break;
            }
        }

        // if the highestIndex is -1, which means its already in the descending order, there is no next highest permutation value
        // so as per the ask of the question we reverse the numbers.
        if (highestIndex == -1) reverse(nums, 0, nums.length - 1);

        // find the swap index
        for (int j = nums.length - 1; j > 0; j--) {

            if (nums[j] > nums[pivotIndex]) {
                swapIndex = j;
                break;
            }
        }
        // do the swap
        swap(nums, pivotIndex, swapIndex);

        // now reverse the suffix = 5320 to 0235
        reverse(nums, highestIndex, nums.length - 1);

        Arrays.stream(nums)
                .forEach(System.out::println);
    }

    public void reverse(int[] nums, int i, int j) {

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    public void swap(int[] nums, int pivotIndex, int swapIndex) {
        // do the swap
        int temp = nums[pivotIndex]; // 2
        nums[pivotIndex] = nums[swapIndex]; // number which is 3 from the swapIndex, is in the place of 2 now.
        nums[swapIndex] = temp;
    }

    public void client() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        nextPermutation(nums);
    }
}
