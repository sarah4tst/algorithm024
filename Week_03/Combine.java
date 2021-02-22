import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @see <a href = "https://leetcode-cn.com/problems/combinations/" >Leetcode Link</a>
 */
public class Combine {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(n, k, 1, new ArrayDeque<>(k), res);
    return res;
  }

  private void dfs(int n, int k, int idx, Deque<Integer> path,
      List<List<Integer>> res) {
    //已够k个元素
    if (path.size() == k) {
      res.add(new ArrayList<>(path));
      return;
    }
    // 解枝: 若剩下元素个数 n-idx + 1 < 需要元素个数k-path.size
    if (n - idx + 1 < k - path.size()) {
      return;
    }

    // 不选择
    dfs(n, k, idx + 1, path, res);
    // 选择
    path.push(idx);
    dfs(n, k, idx + 1, path, res);
    //restore
    path.pop();
  }
}
