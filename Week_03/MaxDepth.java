import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Leetcode Link</a>
 */
public class MaxDepth {

  // 方法一: 递归
  public int maxDepthDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
  }

  // 方法二：BFS
  public int maxDepthBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> que = new LinkedList<>();
    que.offer(root);
    int depth = 0;
    while (!que.isEmpty()) {
      int size = que.size();
      depth++;
      for (int i = 0; i < size; i++) {
        TreeNode node = que.poll();
        if (node.left != null) {
          que.offer(node.left);
        }
        if (node.right != null) {
          que.offer(node.right);
        }
      }
    }
    return depth;
  }
}
