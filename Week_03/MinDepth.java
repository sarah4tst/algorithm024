import java.util.Deque;
import java.util.LinkedList;

public class MinDepth {

  //方法一：DFS
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    // 仅左子树或右子树存在时，返回大值
    // 左右子树均存在时，返回小值
    return 1 + (Math.min(left, right) > 0 ? Math.min(left, right) : Math.max(left, right));
  }

  // 方法二：BFS
  public int minDepthBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      depth++;
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) {
          return depth;
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }
    return depth;
  }
}
