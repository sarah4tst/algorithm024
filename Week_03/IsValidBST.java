import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. Validate Binary Search Tree
 *
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Leetcode Link</a>
 */
public class IsValidBST {

  // 方法一：递归调用，设置上下界，注意是开区间以及数值越界
  public boolean isValidBSTRecursive(TreeNode root) {
    return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helper(TreeNode root, long minValue, long maxValue) {
    if (root == null) {
      return true;
    }
    if (root.val < minValue || root.val > maxValue) {
      return false;
    }
    return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
  }

  // 方法二：中序遍历，遍历的时候比较与前一值，提前返回
  public boolean isValidBSTInorder(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode curr = root, prev = null;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      if (prev != null && curr.val <= prev.val) {
        return false;
      }
      prev = curr;
      curr = curr.right;
    }
    return true;
  }
}
