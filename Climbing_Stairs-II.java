
class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        int INF = Integer.MAX_VALUE / 2;

        // Initialize DP array
        Arrays.fill(dp, INF);

        // Starting stair
        dp[0] = 0;

        // Calculate minimum cost
        for (int i = 1; i <= n; i++) {

            for (int j = Math.max(0, i - 3); j < i; j++) {

                int jump = i - j;

                int cost = costs[i - 1] + jump * jump;

                dp[i] = Math.min(
                    dp[i],
                    dp[j] + cost
                );
            }
        }

        return dp[n];
    }
}
