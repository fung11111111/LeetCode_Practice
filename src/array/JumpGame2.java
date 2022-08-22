package array;

//leetcode 45
public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        int jumps = 0;
        int interval[] = new int[2];
        while(true){
            jumps++;
            int can_reach = -1;
            for(int i = interval[0]; i <= interval[1]; i++){
                can_reach = Math.max(can_reach , i + nums[i]);
            }
            if(can_reach >= n - 1){
                return jumps;
            }
            interval[0] = interval[1] + 1;
            interval[1] = can_reach;
            if(interval[0] > interval[1]) return -1;
        }
    }

    public void client() {
        int[] nums = new int[]{1,3,1};
        System.out.println(jump(nums));
    }

}
