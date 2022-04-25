package backTracking;

import java.util.*;

//leetcode 46
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Integer[] list = new Integer[nums.length];
        generatePermutation(list, nums, 0, result);

        return result;
    }

    public void generatePermutation(Integer[] list, int[] nums, int position, List<List<Integer>> result) {
        if (position == list.length) {
            if (validateArray(list)) {
                List<Integer> res = new ArrayList<>();
                for(int i=0;i< list.length;i++){
                    res.add(list[i]);
                }
                result.add(res);
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                list[position] = Integer.valueOf(nums[i]);
                generatePermutation(list, nums, position + 1, result);
            }

        }


    }

    public boolean validateArray(Integer[] list) {
        Set<Integer> listSet = new HashSet<>();
        for(int i=0; i< list.length;i++){
            listSet.add(list[i]);
        }

        return listSet.size() == list.length;
    }


}
