package array;

import java.util.Arrays;

public class FirstMissingInt {
    public int firstMissingPositive(int[] nums) {
        int missInt = 1;
        boolean needAdd = false;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == missInt) {
                missInt++;
            }


        }

        return missInt;
    }
}
