package array;

public class JumpGame {
    //greedy algo
    //leetcode 55
    public boolean canJump(int[] nums) {

        int finalIdx = nums[0];
        int currentIdx = 0;
        while(currentIdx <= finalIdx && finalIdx < nums.length){
            int jump = currentIdx + nums[currentIdx];
            if(jump> finalIdx){
                finalIdx = jump;
            }

            currentIdx++;
        }

        return finalIdx >= nums.length-1;
    }
}
