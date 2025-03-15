package stackques.faqs;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] ques = new int[]{3, 1, 0, 2, 0, 1};
        System.out.println(trap(ques));
    }

    private static int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int totalWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(l < r){
            if(height[l] <= height[r]){
                if(leftMax > height[l]){
                    totalWater += leftMax-height[l];
                }else{
                    leftMax = height[l];
                }
                l++;
            }else{
                if(rightMax > height[r]){
                    totalWater += rightMax-height[r];
                }else{
                    rightMax = height[r];
                }
                r--;
            }
        }
        return totalWater;
    }
}
