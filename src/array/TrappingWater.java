package array;

//leetcode 42
public class TrappingWater {
    public int trap(int[] height) {
        int output = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left <= right) {
            int currentLeft = height[left];
            int currentRight = height[right];
            leftMax = Math.max(leftMax, currentLeft);
            rightMax = Math.max(rightMax, currentRight);

            if(leftMax < rightMax){
                output += leftMax - currentLeft;
                left++;
            }else{
                output += rightMax - currentRight;
                right --;
            }


        }

        return output;
    }
}
