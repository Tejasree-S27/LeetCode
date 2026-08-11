class Solution {
    public int sumOfUnique(int[] nums) {
        int[] count=new int[101];
        // Count frequency of each number
        for(int num : nums) {
            count[num]++;
        }
        int sum=0;
        // Add numbers that appear exactly once
        for(int num : nums) {
            if(count[num]==1) {
                sum+=num;
            }
        }
        return sum;
    }
}
