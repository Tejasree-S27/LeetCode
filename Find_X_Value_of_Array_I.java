class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] next = new long[k];
            // Start a new subarray
            next[num % k]++;
            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                int newR = (int) ((long) r * (num % k) % k);
                next[newR] += dp[r];
            }
            // Add counts
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }
            dp = next;
        }
        return result;
    }
}
