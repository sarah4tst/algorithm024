import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute {

  /**
   * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
   *
   * @see <a href="https://leetcode-cn.com/problems/permutations/">Leetcode Link</a>
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    Deque<Integer> path = new ArrayDeque<>(nums.length);
    boolean[] used = new boolean[nums.length];
    dfsHelper(nums, path, used, res);
    return res;
  }

  /**
   * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 先排序解法
   *
   * @see <a href="https://leetcode-cn.com/problems/permutations-ii/">Leetcode Link</a>
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int length = nums.length;
    boolean[] used = new boolean[length];
    Deque<Integer> path = new ArrayDeque<>(length);

    Arrays.sort(nums);
    dfsPermuteUnique(nums, path, used, res);
    return res;
  }

  private void dfsPermuteUnique(int[] nums, Deque<Integer> path, boolean[] used,
      List<List<Integer>> res) {
    // 1. terminator: 元素已够
    if (nums.length == path.size()) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 解枝
      if (needProcessForUnique(nums, used, i)) {
        // 2. prepare data
        path.push(nums[i]);
        used[i] = true;

        // 3. drill down
        dfsPermuteUnique(nums, path, used, res);

        // 4. restore
        path.pop();
        used[i] = false;
      }
    }
  }

  private boolean needProcessForUnique(int[] nums, boolean[] used, int i) {
    // 解枝 1. 已使用该元素
    if (used[i]) {
      return false;
    }
    // 解枝 2. 与前一元素相同且前一元素未被用过
    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
      return false;
    }
    return true;
  }

  private void dfsHelper(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
    // 1. terminator: 已选够元素
    if (path.size() == nums.length) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      //解枝：如果该元素已选，跳过
      if (!used[i]) {
        //2. prepare data
        used[i] = true;
        path.push(nums[i]);
        // 3. 每一层可以从未选元素中任意选一个drill down
        dfsHelper(nums, path, used, res);
        //4. restore
        used[i] = false;
        path.pop();
      }
    }
  }

}
