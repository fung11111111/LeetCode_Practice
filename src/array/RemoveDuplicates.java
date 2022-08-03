package array;

import java.util.Arrays;

//leetcode 26
public class RemoveDuplicates {


    public int s2(int [] nums){
        if(nums.length<2){
            return nums.length;
        }
        int index = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[index]=nums[i];
                index++;
            }
        }

        Arrays.stream(nums).forEach(System.out::println);
        return index;
    }

    public void client() {
        int[] a = new int[]{1,1,1,2,2,3,4,4,4,5};
        int[] b = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(s2(a));
        System.out.println(s2(b));

    }

}
