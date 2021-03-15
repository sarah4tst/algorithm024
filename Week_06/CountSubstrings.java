/**
 * 647. Palindromic Substrings
 */
public class CountSubstrings {

  public int countSubstrings(String s) {
    int length = s.length();
    if (length <= 1) {
      return length;
    }
    int count = 0;
    boolean[][] dp = new boolean[length][length];

    // 只需要比较运算上三角
    for (int i = length - 1; i >= 0; i--) {
      for (int j = i; j < length; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i <= 1 || dp[i + 1][j - 1]) {
            dp[i][j] = true;
            count++;
          }
        }
      }
    }

    return count;
  }
}
