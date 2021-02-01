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
    if (nums == null || nums.length == 0) return 0;
    int pos = 1;

    for (int i = 1; i < nums.length ; i++) {
      if (nums[i] != nums[i-1]) {
        nums[pos++] = nums[i];
      }
    }
    return pos;
  }
}
