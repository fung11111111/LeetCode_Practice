package array;

import java.util.HashMap;

//leetcode 1
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int counter = target - nums[i];
            if(map.containsKey(Integer.valueOf(counter))){
                return new int[]{map.get(counter).intValue(), i};
            }else {
                map.put(Integer.valueOf(nums[i]),Integer.valueOf(i));
            }
        }
        return new int[]{0,0};
    }


}
