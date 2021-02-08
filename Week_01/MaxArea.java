/**
 * Container With Most Water
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Leetcode Link</a>
 */
public class MaxArea {

  public int maxArea(int[] a) {
    int maxArea = 0;
    for (int i = 0, j = a.length - 1; i < j; ) {
      int minHeight = a[i] < a[j] ? a[i++] : a[j--];
      maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
    }
    return maxArea;
  }
}
