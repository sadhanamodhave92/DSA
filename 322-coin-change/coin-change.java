class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount + 1; // large number to simulate infinity
        
        // dp[i][j] = min coins needed using first i coins to make sum j
        int[][] dp = new int[n + 1][amount + 1];
        
        // Initialize first row (0 coins -> impossible for any positive amount)
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = INF;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // can't take this coin
                } else {
                    dp[i][j] = Math.min(
                        dp[i - 1][j],                // don't take coin
                        1 + dp[i][j - coins[i - 1]]  // take coin again (unbounded)
                    );
                }
            }
        }
        
        return dp[n][amount] >= INF ? -1 : dp[n][amount];
    }
}
