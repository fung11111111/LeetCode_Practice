package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//leetcode 80
public class RemoveDuplicatedFromSortedArray {


    public int removeDuplicates(int[] nums) {
        int duplicated = 0;
        int[] newArr = nums.clone();
        List<Integer> nonDuplicatedIdx = new ArrayList<>();
        List<Integer> duplicatedIdx = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int current = nums[i];
            int currentCount = 1;
            nonDuplicatedIdx.add(i);
            while (j < nums.length) {
                int next = nums[j];
                if (current == next) {
                    currentCount++;
                    if (currentCount <= 2) {
                        nonDuplicatedIdx.add(j);
                    } else {
                        duplicated++;
                        duplicatedIdx.add(j);
                    }
                    j++;
                } else {
                    break;
                }
            }
            i = j -1;
        }
        int k = 0;
        for (Integer num : nonDuplicatedIdx) {
            nums[k] = newArr[num.intValue()];
            k++;
        }
        for (Integer num : duplicatedIdx) {
            nums[k] = newArr[num.intValue()];
            k++;
        }


        return nums.length - duplicated;
    }

    public int removeDuplicatesOptimal(int[] nums) {
        int left = 0, right = 0;
        int count = 0;

        while(right < nums.length) {

            if(right!=0 && nums[right] != nums[right-1]) {
                count = 0;
            }

            if(count== 0 || nums[right]==nums[right-1]) {
                count++;
                if(count <= 2) {
                    nums[left++] = nums[right];
                }
            }

            right++;
        }

        return left;
    }

    public void client(){
        int [] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicatesOptimal(nums));
    }
}
