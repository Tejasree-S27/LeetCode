class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        int ans = solve(stoneValue, 0);
        if (ans > 0) return "Alice";
        if (ans < 0) return "Bob";
        return "Tie";
    }
    public int solve(int[] arr, int i) {
        if (i >= arr.length) return 0;
        if (dp[i] != null) return dp[i];
        int sum = 0, best = Integer.MIN_VALUE;
        for (int j = i; j < arr.length && j < i + 3; j++) {
            sum += arr[j];
            best = Math.max(best, sum - solve(arr, j + 1));
        }
        return dp[i] = best;
    }
}
