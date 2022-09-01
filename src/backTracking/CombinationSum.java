package backTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 39
//backtracking
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        int size = candidates.length;
        if (size == 0) {
            return resultList;
        } else {
            Arrays.sort(candidates);
            for (int i = 0; i < size; i++) {
                int currentSum = candidates[i];
                if (currentSum > target) return resultList;
                List<Integer> tmpList = Arrays.asList(candidates[i]);
                calculator(i, candidates, target, resultList, tmpList, currentSum);
            }

        }

        return resultList;
    }

    public void calculator(int left, int[] candidates, int target, List<List<Integer>> result, List<Integer> tmpList, int currentSum) {
        if (currentSum > target) {
            return;
        } else if (currentSum == target) {
            result.add(tmpList);
        } else {
            while (left < candidates.length) {
                int tmpSum = currentSum + candidates[left];
                if (tmpSum <= target) {
                    List<Integer> newTmpList = new ArrayList<>();
                    newTmpList.addAll(tmpList);
                    newTmpList.add(candidates[left]);
                    calculator(left, candidates, target, result, newTmpList, tmpSum);
                }
                left++;
            }
        }
    }


    public void client() {
        int[] can = new int[]{7,3,9,6};
        List<List<Integer>> res = combinationSum(can, 6);


        for(List<Integer> l: res){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();

        }


    }
}
