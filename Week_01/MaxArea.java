/**
 * Container With Most Water
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">Leetcode Link</a>
 */
public class MaxArea {

  // 方法一：暴力法，O(n^2), 超时
  public int maxAreaBruteForce(int[] a) {
    int max = 0;
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i + 1; j < a.length; j++) {
        max = Math.max((j - i) * Math.min(a[i], a[j]), max);
      }
    }
    return max;
  }

  // 方法二：双指针法，无优化，O(n)
  public int maxAreaTwoPointer(int[] a) {
    int maxArea = 0, i = 0, j = a.length - 1;
    while (i < j) {
      maxArea = Math.max(maxArea, (j - i) * Math.min(a[i], a[j]));

      if (a[i] < a[j]) {
        i++;
      } else {
        j--;
      }
    }
    return maxArea;
  }

  // 方法三：双指针法，优化版省去求无效的面积O(n)
  public int maxAreaTwoPointerOpt(int[] a) {
    int maxArea = 0, i = 0, j = a.length - 1;

    while (i < j) {
      int minHeight = Math.min(a[i], a[j]);
      maxArea = Math.max(maxArea, (j - i) * minHeight);
      while (i < j && a[i] <= minHeight) {
        i++;
      }
      while (i < j && a[j] <= minHeight) {
        j--;
      }
    }
    return maxArea;
  }
}
