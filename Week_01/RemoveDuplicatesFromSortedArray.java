public class RemoveDuplicatesFromSortedArray {

  /**
   * Remove Duplicates from Sorted Array and returns the new length
   *
   * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Leetcode
   * link</a>
   *
   * <p>Do not allocate extra space for another array, you must do this by modifying the input array
   * in-place with O(1) extra memory.
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      // 与上一个有效元素比较，不同的时候赋值
      if (nums[i] != nums[res]) {
        res++;
        nums[res] = nums[i];
      }
    }
    return res + 1;
  }
}
