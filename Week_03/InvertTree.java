import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. Invert Binary Tree
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Leetcode Link</a>
 */
public class InvertTree {

  // 方法一：递归, 因为不是尾递归，会受限于程序stackoverflow
  public TreeNode invertTreeRecursive(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = invertTreeRecursive(right);
    root.right = invertTreeRecursive(left);
    return root;
  }

  // 方法二：用BFS方法
  public TreeNode invertTreeBFS(TreeNode root) {
    if (root == null) {
      return root;
    }
    Deque<TreeNode> que = new LinkedList<>();
    que.offer(root);

    while (!que.isEmpty()) {
      int size = que.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = que.poll();
        // 先交换左右结点
        TreeNode left = curr.left;
        curr.left = curr.right;
        curr.right = left;
        // 交换后的左右结点入队列
        if (curr.left != null) {
          que.offer(curr.left);
        }
        if (curr.right != null) {
          que.offer(curr.right);
        }
      }
    }
    return root;
  }
}
