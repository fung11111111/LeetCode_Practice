package array;

import java.util.Arrays;

//leetcode 88
public class MergeSortedElement {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = m + n;
        int[] newArr = nums1.clone();

        int i = 0;
        int j = 0;
        int k = 0;


        while (k < size) {
            if(nums2.length == 0){
                break;
            }
            int num1Current = i < nums1.length ? newArr[i] : 0;
            int num2Current = j < nums2.length ?nums2[j] : 0;


            if (i < m && j < n) {
                if (num1Current <= num2Current) {
                    nums1[k] = num1Current;
                    i++;
                } else {
                    nums1[k] = num2Current;
                    j++;
                }
            } else if(j < n){
                nums1[k] = num2Current;
                j++;
            }else {
                nums1[k] = num1Current;
                i++;
            }
            k++;
        }

        Arrays.stream(nums1)
                .forEach(System.out::println);


        //faster than 100% :)
    }

    public void client() {
        int[] num1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] num2 = new int[]{1,2,2};

        merge(num1, 6, num2, 3);
    }

}
