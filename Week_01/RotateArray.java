public class RotateArray {

  /**
   * Given an array, rotate the array to the right by k steps, where k is non-negative.
   *
   * @see <a href="https://leetcode.com/problems/rotate-array/">Leetcode Link</a>
   */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k %= len;
    if (len <= 1 || k == 0) {
      return;
    }
    int[] tmp = new int[len];
    for (int i = 0; i < len; i++) {
      // move ksteps to right
      tmp[(i + k) % len] = nums[i];
    }
    for (int i = 0; i < len; i++) {
      nums[i] = tmp[i];
    }
  }

  /**
   * Follow up, rotate by reverse, time O(n), space O(1)
   */
  private void rotateByReverse(int[] nums, int k, int len) {
    reverse(nums, 0, len - 1); // reverse all nums
    reverse(nums, 0, k - 1); // reverse first k nums
    reverse(nums, k, len - 1); //reverse last n-k nums
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int tmp = nums[end];
      nums[end--] = nums[start];
      nums[start++] = tmp;
    }
  }

  /**
   * burte force, rotate k times, each time rotate 1 step to right
   *
   * @param nums array to rotate
   * @param k    steps
   * @param len  array length
   */
  private void rotateToRigthBySteps(int[] nums, int k, int len) {
    for (int i = 0; i < k; i++) {
      rotateToRight(nums, len);
    }
  }

  private void rotateToRight(int[] nums, int len) {
    int tmp = nums[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      nums[i + 1] = nums[i];
    }
    nums[0] = tmp;
  }
}
