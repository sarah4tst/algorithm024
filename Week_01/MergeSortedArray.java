/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/">Leetcode Link</a>
 */
public class MergeSortedArray {

  // 背下来
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    while (n > 0) {
      nums1[m + n - 1] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
    }
  }

  public void mergeEasyToRead(int[] nums1, int m, int[] nums2, int n) {
    // three pointers, iterate nums2 from end to start
    int p = m + n - 1, p1 = m - 1, p2 = n - 1;
    while (p2 >= 0) {
      // check p1 to avoid outofbound
      if (p1 >= 0 && nums1[p1] > nums2[p2]) {
        nums1[p--] = nums1[p1--];
      } else {
        nums1[p--] = nums2[p2--];
      }
    }
  }
}
