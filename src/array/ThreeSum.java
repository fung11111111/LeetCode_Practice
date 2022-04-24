package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        HashSet numSet = new HashSet();
        int left = 0;
        int right = 0;
        Integer pre = null;

        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left != i && right != left && left < right && right > left) {
                int current = nums[i];
                int middle = nums[left];
                int last = nums[right];

                if (Integer.valueOf(current).equals(pre)) {
                    break;
                }

                if (current + middle + last < 0) {
                    left++;
                    continue;
                } else if (current + middle + last > 0) {
                    right--;
                    continue;
                }

                if (current + middle + last == 0) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(current);
                    tmpList.add(middle);
                    tmpList.add(last);
                    result.add(tmpList);
                    left++;
                    right--;
                    numSet.add(tmpList);
                    continue;
                }

            }
        }



        return (List<List<Integer>>) numSet.stream().collect(Collectors.toList());
    }
}
