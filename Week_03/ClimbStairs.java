/**
 * 70. Climbing Stairs
 *
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">Leetcode Link</a>
 */
public class ClimbStairs {

  public static void main(String[] args) {
    ClimbStairs sol = new ClimbStairs();
    System.out.println(sol.climbStairsRecursiveMemo(5));
  }

  // 方法一：暴力傻递归，会超时。自顶向下 f(n) = f(n-1)+f(n-2)
  public int climbStairsRecursive(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return n;
    }
    return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
  }

  // 方法二：记忆法 + 递归 f(n) = f(n-1)+f(n-2)
  public int climbStairsRecursiveMemo(int n) {
    int[] memo = new int[n + 1];
    return climbStairsRecursiveMemoHelper(n, memo);
  }

  private int climbStairsRecursiveMemoHelper(int n, int[] memo) {
    if (n <= 2) {
      return n;
    }
    if (memo[n] > 0) {
      return memo[n];
    }

    memo[n] =
        climbStairsRecursiveMemoHelper(n - 1, memo) + climbStairsRecursiveMemoHelper(n - 2, memo);

    return memo[n];
  }

  // 方法三：DP (自底向上递推). 空间O(n)
  public int climbStairsDP(int n) {
    // dp[i] = dp[i-1] + dp[i-2], dp[1] = 1, dp[2] = 2
    if (n <= 2) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // 方法三：DP (自底向上递推),无需记录中间结果,空间O(1)
  public int climbStairsDPSpaceSaving(int n) {
    // dp[i] = dp[i-1] + dp[i-2], dp[1] = 1, dp[2] = 2
    if (n <= 2) {
      return n;
    }
    int pre = 2, prepre = 1;
    for (int i = 3; i <= n; i++) {
      int tmp = pre + prepre;
      prepre = pre;
      pre = tmp;
    }
    return pre;
  }
}
