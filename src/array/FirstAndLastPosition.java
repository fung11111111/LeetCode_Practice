package array;

import java.util.Arrays;

//leetcode 34
//todo can use binary search
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-99, -99};

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        if(nums.length == 1){
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }

        int left = 0;
        int right = nums.length - 1;
        int startIdx = -1;
        int endIdx = -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                startIdx = middle;
                endIdx = middle;
                System.out.println(startIdx);
                while (startIdx >0 && nums[startIdx - 1] == target) {
                    startIdx--;
                }
                while (endIdx < nums.length-1 && nums[endIdx + 1] == target) {
                    endIdx++;
                }
                return new int[]{startIdx, endIdx};
            } else if (nums[middle] > target) {
                right = middle -1;
            } else {
                left = middle +1;
            }

        }
        return new int[]{startIdx, endIdx};
    }


    //binary search solution
//    public int[] searchRange(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        int middle = 0;
//
//        while (left <= right) {
//            middle = left + (right - left)/2;
//
//            if (nums[middle] == target) {  //Target found
//                int i = middle;
//                int j = middle;
//
//                while (i > 0 && nums[i - 1] == target) { //Find lower boundary
//                    i--;
//                }
//                while (j < nums.length - 1 && nums[j + 1] == target) { //Find upper boundary
//                    j++;
//                }
//
//                return new int[] {i, j};
//            } else if (nums[middle] < target) {
//                left = middle + 1;
//            } else {
//                right = middle - 1;
//            }
//        }
//
//        return new int[] {-1, -1};    // by default return not found
//    }


}
