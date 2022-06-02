package array;

//leetcode 33
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int first = nums[0];
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        if (target == first) return 0;

        while (left <= right) {
            int middle = (left + right) / 2;
            if(left == 0 && right == 0 && nums[middle] != target) return -1;

            if (nums[middle] == target) {
                return middle;
            } else if (middle + 1 < nums.length && nums[middle + 1] == target) {
                return middle + 1;
            } else if (middle - 1 >= 0 && nums[middle - 1] == target) {
                return middle - 1;
            } else if (nums[middle] >= first) {
                if(target > nums[middle]){
                    left = middle + 1;
                    if (left < nums.length) first = nums[left];
                }else {
                    if(target <= first){
                        left = middle + 1;
                        if (left < nums.length) first = nums[left];
                    }else {
                        right = middle - 1;
                    }
                }
            } else if (nums[middle] <= first) {
                if (target >= first) {
                    right = middle - 1;
                } else {
                    if (target > nums[middle]) {
                        left = middle + 1;
                        if (left < nums.length) first = nums[left];
                    } else {
                        right = middle - 1;
                    }
                }
            }

        }


        return -1;
    }
}
