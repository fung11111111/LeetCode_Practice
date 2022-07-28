package array;

import java.lang.reflect.Array;
import java.util.Arrays;

//leetcode 16
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Integer closest = null;
        Integer sum = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < nums.length && k > j) {
                int tmpSum = nums[i] + nums[j] + nums[k];
                int distance = 0;
                if (tmpSum > target) {
                    distance = tmpSum - target;
                    k--;
                } else {
                    distance = target - tmpSum;
                    j++;
                }

                if (distance < 0) {
                    distance *= -1;
                }
                if (closest == null || sum == null) {
                    closest = distance;
                    sum = tmpSum;
                } else {
                    if (distance <= closest) {
                        closest = distance;
                        sum = tmpSum;
                    }
                }
            }
        }


        return sum;
    }

    public void client() {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

}
