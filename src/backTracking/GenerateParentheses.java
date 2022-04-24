package backTracking;

import java.util.ArrayList;
import java.util.List;

// leetcode 22
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        char[] combination = new char[n * 2];
        generateStr(combination, 0, result);


        return result;
    }

    public void generateStr(char[] arr, int position, List<String> resultList) {
        if (position == arr.length) {
            if (validation(arr)) {
                resultList.add(String.valueOf(arr));
            }
        } else {
            arr[position] = '(';
            generateStr(arr, position + 1, resultList);
            arr[position] = ')';
            generateStr(arr, position + 1, resultList);
        }

    }

    public boolean validation(char[] arr) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (right > left) return false;
        }


        return (left == right);
    }
}
