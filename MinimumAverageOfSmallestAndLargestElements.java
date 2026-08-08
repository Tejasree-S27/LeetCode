class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double minAvg=Double.MAX_VALUE;
        int lt=0;
        int rt=nums.length-1;
        while(lt<rt) {
            double avg=(nums[lt]+nums[rt])/2.0;
            minAvg=Math.min(minAvg,avg);
            lt++;
            rt--;
        }
        return minAvg;
    }
}
