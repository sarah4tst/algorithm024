public class MoveZeroes {

  /**
   * Move Zeroes. Given an array nums, write a function to move all 0's to the end of it while
   * maintaining the relative order of the non-zero elements.
   *
   * @see <a href="https://leetcode.com/problems/move-zeroes/">Leetcode Link</a>
   */
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int nonZeroes = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        // 交换元素同时填充0
        if (nonZeroes != i) {
          nums[nonZeroes] = nums[i];
          nums[i] = 0;
        }
        nonZeroes++;
      }
    }
  }
}
