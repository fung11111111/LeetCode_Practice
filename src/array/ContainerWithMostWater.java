package array;

//leetcode 11
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left< right){
            int areaHeight = height[left] < height[right] ? height[left] : height[right];
            int area = areaHeight * (right - left);
            if (area > max) {
                max = area;
            }

            if(height[right] < height[left]){
                right --;
            }else {
                left++;
            }

        }

        return max;
    }
}
