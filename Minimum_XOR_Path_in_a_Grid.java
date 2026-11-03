class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] stores all possible XOR values
        // that can reach cell (i, j).
        Set<Integer>[][] dp = new HashSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        dp[0][0].add(grid[0][0]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // Move down from the cell above.
                if (i > 0) {
                    for (int x : dp[i - 1][j]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }
                // Move right from the cell on the left.
                if (j > 0) {
                    for (int x : dp[i][j - 1]) {
                        dp[i][j].add(x ^ grid[i][j]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : dp[m - 1][n - 1]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}
