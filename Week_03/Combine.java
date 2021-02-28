import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine {

  public static void main(String[] args) {
    Combine combine = new Combine();
    System.out.println(combine.combinationSum4(new int[]{
        2, 1, 3
    }, 35));
//    System.out.println(combine.combinationSum3(2, 17));
  }

  /**
   * 377. 组合总和 Ⅳ
   * <p> 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
   * <p> 请注意，顺序不同的序列被视作不同的组合。
   */
  public int combinationSum4(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (num <= i) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }

  /**
   * 40. 组合总和 II 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
   *
   * <p>candidates 中的每个数字在每个组合中只能使用一次。
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new LinkedList<>();
    if (candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    dfsCombineSum2(candidates, target, 0, new LinkedList<>(), res);
    return res;
  }

  private void dfsCombineSum2(int[] candidates, int target, int startIdx, Deque<Integer> path,
      List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = startIdx; i < candidates.length; i++) {
      //
      if (candidates[i] > target) {
        return;
      }
      if (i > startIdx && candidates[i] == candidates[i - 1]) {
        continue;
      }
      path.addLast(candidates[i]);
      dfsCombineSum2(candidates, target - candidates[i], i + 1, path, res);
      path.removeLast();
    }
  }

  /**
   * 39. 组合总和
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new LinkedList<>();
    if (candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    dfsCombineSum(candidates, target, 0, new LinkedList<>(), res);
    return res;
  }

  private void dfsCombineSum(int[] candidates, int target, int startIdx,
      Deque<Integer> path,
      List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }

    for (int i = startIdx; i < candidates.length; i++) {
      if (candidates[i] > target) {
        return;
      }
      path.addLast(candidates[i]);
      dfsCombineSum(candidates, target - candidates[i], i, path, res);
      path.removeLast();
    }
  }

  /**
   * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
   *
   * @see <a href = "https://leetcode-cn.com/problems/combinations/" >Leetcode Link</a>
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new LinkedList<>();
    if (n < k) {
      return res;
    }
    dfsCombine(n, k, 1, new ArrayDeque<Integer>(k), res);
    return res;
  }

  private void dfsCombine(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
    if (k == 0) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = start; i <= n - k + 1; i++) {
      path.addLast(i);
      dfsCombine(n, k - 1, i + 1, path, res);
      path.removeLast();
    }
  }

  /**
   * 216. Combination Sum III 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
   *
   * <p>所有数字都是正整数。 解集不能包含重复的组合。
   */
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new LinkedList<>();
    if (k <= 0 || n < 1) {
      return res;
    }
    dfsCombineSum3(k, n, 1, new ArrayDeque<>(k), res);
    return res;
  }

  private void dfsCombineSum3(int k, int target, int startIdx, Deque<Integer> path,
      List<List<Integer>> res) {
    if (0 == target && k == 0) {
      res.add(new ArrayList<Integer>(path));
      return;
    }
    for (int i = startIdx; i <= 9; i++) {
      if (i > target) {
        return;
      }
      path.addLast(i);
      dfsCombineSum3(k - 1, target - i, i + 1, path, res);
      path.removeLast();
    }
  }
}
