class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Prefix sum matrix (extra row & column)
        int[][] pre = new int[m + 1][n + 1];

        // Build prefix sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];

        // Calculate block sum for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                // Convert to prefix sum indices (+1)
                ans[i][j] = pre[r2 + 1][c2 + 1]
                          - pre[r1][c2 + 1]
                          - pre[r2 + 1][c1]
                          + pre[r1][c1];
            }
        }

        return ans;
    }
}
