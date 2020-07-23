class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < column; i++) {
            for (int j = 1; j < row; j++) {
                dp[j][i] = Integer.min(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 5}, {3, 2, 1}};
        System.out.println(new MinPathSum().minPathSum(a));
    }
}
