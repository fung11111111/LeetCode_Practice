package array;


//leetcode 179
//todo: not fix
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String result = "" + nums[0];
        for (int j = 1; j < nums.length; j++) {
            String currentNum = "" + nums[j];
            int currentFirstP = Character.getNumericValue(currentNum.charAt(0));
            int originalFirstP = Character.getNumericValue(result.charAt(0));
            if (originalFirstP > currentFirstP) {
                result += currentNum;
            } else if (originalFirstP < currentFirstP) {
                result = currentNum + result;
            } else {
                int currentLastP = Character.getNumericValue(currentNum.charAt(currentNum.length() - 1));
                int originalLastP = Character.getNumericValue(result.charAt(result.length() - 1));
                if (originalLastP >= currentLastP) {
                    result += currentNum;
                } else {
                    result = currentNum + result;
                }
            }
        }


        return result;
    }
}
