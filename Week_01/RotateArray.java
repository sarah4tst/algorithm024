public class RotateArray {

  /**
   * Given an array, rotate the array to the right by k steps, where k is non-negative.
   *
   * @see <a href="https://leetcode.com/problems/rotate-array/">Leetcode Link</a>
   */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    k %= len;
    if (k == 0) {
      return;
    }
    rotateExtraSpace(nums, k, len);
  }

  /**
   * Use extra space and array copy. time O(n), space O(n)
   */
  private void rotateExtraSpace(int[] nums, int k, int len) {
    int[] tmp = new int[len];
    System.arraycopy(nums, 0, tmp, k, len - k);
    System.arraycopy(nums, len - k, tmp, 0, k);
    System.arraycopy(tmp, 0, nums, 0, len);
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
    System.arraycopy(nums, 0, nums, 1, len - 1);
    nums[0] = tmp;
  }
}
