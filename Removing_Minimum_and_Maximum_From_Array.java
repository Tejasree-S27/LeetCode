class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minIndex=0,maxIndex=0;
        // Find minimum and maximum positions
        for(int i=0;i<n;i++) {
            if(nums[i]<nums[minIndex]) 
            minIndex=i;
            if(nums[i]>nums[maxIndex]) 
            maxIndex=i;
        }
        int left=Math.min(minIndex,maxIndex);
        int right=Math.max(minIndex,maxIndex);
        // Three possible ways
        int front=right+1;             // Remove from front
        int back=n-left;               // Remove from back
        int both=(left+1)+(n-right); // Remove from both sides
        return Math.min(front,Math.min(back,both));
    }
}
