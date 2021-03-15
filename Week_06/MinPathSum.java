/*
  64. Minimum Path Sum
 */
public class MinPathSum {

  public static void main(String[] args) {
    //
    int[][] grid = new int[][]{
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    MinPathSum test = new MinPathSum();
    System.out.println("grid = " + test.minPathSum(grid));
  }

  // 无优化：空间复杂度M*N
  public int minPathSum(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    // dp[i][j] = 从起点走到i,j的最短路径
    // dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
    int[][] dp = new int[rows][cols];
    dp[0][0] = grid[0][0];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i > 0 && j > 0) {
          dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        } else if (j > 0) {
          dp[i][j] = grid[i][j] + dp[0][j - 1];
        } else if (i > 0) {
          dp[i][j] = grid[i][j] + dp[i - 1][j];
        }

      }
    }
    return dp[rows - 1][cols - 1];
  }

  // 优化：空间O(N)
  public int minPathSumOpt(int[][] grid) {
    int rows = grid.length, cols = grid[0].length;
    // dp[j] = 从起点走到j的最短路径
    // dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
    int[] dp = new int[cols];
    // 初始化
    dp[0] = grid[0][0];
    for (int j = 1; j < cols; j++) {
      dp[j] = grid[0][j] + dp[j - 1];
    }

    for (int i = 1; i < rows; i++) {
      dp[0] += grid[i][0];
      for (int j = 1; j < cols; j++) {
        dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
      }
    }
    return dp[cols - 1];
  }
}
