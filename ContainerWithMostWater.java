class Solution {
    public int maxArea(int[] height) {
        int maxWater=0;
        for (int i=0;i<height.length;i++) 
        {
            for (int j=i+1;j<height.length;j++) 
            {
                int width=j-i;
                int minHeight=Math.min(height[i],height[j]);
                int area=width*minHeight;
                maxWater=Math.max(maxWater,area);
            }
        }
        return maxWater;
    }
}
