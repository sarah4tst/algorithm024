import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionTwoArrays {
  /**
   * Intersection of Two Arrays
   * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Leetcode Link</a>
   */
  public int[] intersection(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }
    Set<Integer> set = new HashSet<>();
    Set<Integer> interSet = new HashSet<>();
    for (int n : nums1) {
      set.add(n);
    }
    for (int n : nums2) {
      if (set.contains(n)) interSet.add(n);
    }
    int[] res = new int[interSet.size()];
    int i = 0;
    for (int n : interSet) {
      res[i++] = n;
    }
    return res;
  }

  /**
   * Intersection of Two Arrays II, use hashmap
   * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Leetcode Link</a>
   * @return Each element in the result should appear as many times as it shows in both arrays.
   */
  public int[] intersectHashMap(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }
    Map<Integer,Integer> map1 = new HashMap<>();
    int[] res = new int[nums1.length];
    int idx = 0;

    for (int n : nums1) {
        int curr = map1.getOrDefault(n,0);
        map1.put(n, curr + 1);
    }
    for (int n : nums2) {
      int curr = map1.getOrDefault(n,0);
      if (curr > 0) {
        map1.put(n, curr - 1);
        res[idx++] = n;
      }
    }
    return Arrays.copyOfRange(res, 0, idx);
  }

  /**
   * Intersection of Two Arrays II, sorted
   * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Leetcode Link</a>
   * @return Each element in the result should appear as many times as it shows in both arrays.
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
      return new int[0];
    }
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, idx = 0;
    int m = nums1.length, n = nums2.length;
    int[] res = new int[nums1.length];
    while ( i < m && j < n) {
      if (nums1[i] == nums2[j]) {
        res[idx++] = nums1[i++];
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return Arrays.copyOfRange(res, 0, idx);
  }
}
