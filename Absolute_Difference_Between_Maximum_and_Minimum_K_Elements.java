class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int small=0,large=0;
        int n=nums.length;
        for(int i=0;i<k;i++) {
            small+=nums[i];
            large+=nums[n-1-i];
        }
        return Math.abs(large-small);
    }
}
