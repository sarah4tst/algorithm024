public class MoveZeroes {

  /**
   * Move Zeroes. Given an array nums, write a function to move all 0's to the end of it while
   * maintaining the relative order of the non-zero elements.
   *
   * @see <a href="https://leetcode.com/problems/move-zeroes/">Leetcode Link</a>
   */
  public void moveZeroes(int[] nums) {
    for (int i = 0, pos=0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != pos) {
          nums[pos] = nums[i];
          nums[i] = 0;
        }
        pos++;
      }
    }
  }
}
