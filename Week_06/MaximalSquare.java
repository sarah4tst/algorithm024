/**
 * 221. Maximal Square
 */
public class MaximalSquare {

  // 方法二：DP 空间优化，只需要一维DP数组，辅以左上角
  public int maximalSquareOpt(char[][] matrix) {
    int cols = matrix[0].length;
    int maxSide = 0;
    int[] dp = new int[cols + 1];
    for (char[] chars : matrix) {
      int northwest = 0; // 西北角、左上角
      for (int i = 1; i <= cols; i++) {
        // 将左上角记录下来
        int nextNorthwest = dp[i];
        if (chars[i - 1] == '1') {
          dp[i] = Math.min(Math.min(dp[i], dp[i - 1]), northwest) + 1;
          maxSide = Math.max(maxSide, dp[i]);
        } else {
          dp[i] = 0;
        }
        northwest = nextNorthwest;
      }
    }
    return maxSide * maxSide;
  }

  // 方法一：DP
  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    int maxSide = 0;
    int[][] dp = new int[rows + 1][cols + 1];

    // DP(i,j): 以matrix(i-1,j-1)为右下角的正方形的最大边长
    //    if (grid[i - 1][j - 1] == '1') {
    //      dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
    //    }
    // 需要返回面积，所以在计算每个dp[i][j]的时候，就把当前最大边长记下

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
          maxSide = Math.max(maxSide, dp[i][j]);
        }
      }
    }
    return maxSide * maxSide;
  }
}
