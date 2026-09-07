class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long dp = 1; // Includes empty subsequence
        long[] last = new long[26];
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            long newDp = (2 * dp % MOD - last[index] + MOD) % MOD;
            last[index] = dp;
            dp = newDp;
        }
        // Remove empty subsequence
        return (int) ((dp - 1 + MOD) % MOD);
    }
}
