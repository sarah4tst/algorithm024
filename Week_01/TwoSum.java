import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such
   * that they add up to target.
   * @see <a href="https://leetcode.com/problems/two-sum/">Leetcode Link</a>
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int toMatch = target - nums[i];
      if (!map.containsKey(toMatch)) {
        map.put(nums[i], i);
      } else {
        return new int[]{map.get(toMatch), i};
      }
    }
    return null;
  }

  /**
   * @param numbers sorted array
   * @param target  target sum
   * @return indices of the two numbers (1-indexed)
   * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">LeetCode
   * Link</a>
   */
  public int[] twoSumSorted(int[] numbers, int target) {
    for (int i = 0, j = numbers.length - 1; i < j; ) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[]{i + 1, j + 1};
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return null;
  }
}
