public class PlusOne {

  /**
   * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
   * @see <a href="https://leetcode.com/problems/plus-one/">Leetcode Link</a>
   */
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    for (int i = len-1; i > -1; i--) {
      digits[i] = (digits[i]+1) % 10;
      if (digits[i] != 0) return digits;
    }
    int[] res = new int[len+1];
    res[0] = 1;
    return res;
  }
}
