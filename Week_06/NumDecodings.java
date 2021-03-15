/**
 * 91. Decode Ways
 */
public class NumDecodings {

  public static void main(String[] args) {
    NumDecodings test = new NumDecodings();
    System.out.println("test.numDecodings(\"26\") = " + test.numDecodingsDPOpt("26"));
  }

  // 方法三：DP，空间优化
  public int numDecodingsDPOpt(String s) {
    if (s == null || s.length() < 1 || s.charAt(0) == '0') {
      return 0;
    }
    int length = s.length();
    int prepre = 1, pre = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= length; i++) {
      int cur = 0;
      int first = Integer.valueOf(s.substring(i - 1, i));
      int second = Integer.valueOf(s.substring(i - 2, i));
      if (first > 0) {
        cur = pre;
      }
      if (second >= 10 && second <= 26) {
        cur += prepre;
      }
      prepre = pre;
      pre = cur;
    }
    return pre;
  }

  // 方法二：一堆DP数组，空间复杂度O(n)
  public int numDecodingsDP(String s) {
    if (s == null || s.length() < 1 || s.charAt(0) == '0') {
      return 0;
    }
    int length = s.length();
    // dp[i]: 解码到s[i]的解码方法的总数
    // dp[i] = dp[i-1] + dp[i-2]： (但加限制条件)
    int[] dp = new int[length + 1];

    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= length; i++) {
      int first = Integer.valueOf(s.substring(i - 1, i));
      int second = Integer.valueOf(s.substring(i - 2, i));
      if (first > 0) {
        dp[i] += dp[i - 1];
      }
      if (second >= 10 && second <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[length];
  }

  // 方法一：递归，超时。分两种情况：子串不以0开始的时候，选一个下探；选两个字符>=10&&<=26的时候，下探
  public int numDecodingsRec(String s) {
    if (s == null || s.length() < 1 || s.charAt(0) == '0') {
      return 0;
    }
    return helper(s, 0);
  }

  private int helper(String s, int level) {
    if (level >= s.length()) {
      return 1;
    }

    int nextLevel = 0, nextNextLevel = 0;

    // 取一个
    if (s.charAt(level) != '0') {
      nextLevel = helper(s, level + 1);
    }
    // 取两个
    if (level + 2 <= s.length()) {
      int num = Integer.parseInt(s.substring(level, level + 2));
      if (num >= 10 && num <= 26) {
        nextNextLevel = helper(s, level + 2);
      }
    }
    return nextLevel + nextNextLevel;
  }
}
