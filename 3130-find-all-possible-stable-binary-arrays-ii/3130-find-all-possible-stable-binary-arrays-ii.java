class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long MOD = 1_000_000_007;
        // dp[i][j][0] = number of stable arrays with i zeros, j ones, ending in 0
        // dp[i][j][1] = number of stable arrays with i zeros, j ones, ending in 1
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: single blocks of 0s or 1s within the limit
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // Ending with 0:
                // We can append a 0 to any stable array ending in 0 or 1
                // But we must subtract arrays that would exceed the limit of consecutive 0s
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // Subtract configurations where adding this 0 creates a block of (limit + 1) zeros
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // Ending with 1:
                // Same logic as above, but for 1s
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}