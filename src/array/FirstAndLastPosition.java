package array;

import java.util.Arrays;

//leetcode 34
//todo can use binary search
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-99,-99};

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        getIdx(nums, target, result, 0);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }


    public void getIdx(int[] nums, int target, int result[], int startIdx) {
        int middleIdx = (startIdx + nums.length) / 2;

        if (target > nums[middleIdx] && middleIdx < nums.length - 1) {
            getIdx(nums, target, result, middleIdx);
        }
        System.out.println(middleIdx);
        int startPosition = -1;
        int endPosition = -1;
        if (target < nums[middleIdx]) {
            System.out.println(middleIdx);
            for (int i = startIdx; i <= middleIdx; i++) {
                if (nums[i] == target) {
                    if (startPosition == -1) {
                        startPosition = i;
                    }
                    if (startPosition != -1) {
                        endPosition = i;
                    }
                }
            }
            result[0] = startPosition;
            result[1] = endPosition;
        }
        if (target == nums[middleIdx]) {
            System.out.println("start: " + startIdx);
            System.out.println("middle: " + middleIdx);
            for (int i = startIdx; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (startPosition == -1) {
                        System.out.println("get Start" + i);
                        startPosition = i;

                    }
                    if (startPosition != -1) {
                        System.out.println("get End" + i);
                        endPosition = i;
                    }
                }
            }
            result[0] = startPosition;
            result[1] = endPosition;
        }
        if (result[0] == -99) {
            result[0] = -1;
            result[1] = -1;
        }


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
