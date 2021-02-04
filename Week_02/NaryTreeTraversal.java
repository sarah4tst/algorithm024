import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeTraversal {

  /**
   * N-ary Tree Postorder Traversal -- Recursive
   * @see <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">Leetcode Link</a>
   */
  public List<Integer> postorderRecursive(NaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    postHelper(root,res);
    return res;
  }

  private void postHelper(NaryTreeNode root, List<Integer> res) {
    if (root == null) return;
    for (NaryTreeNode node : root.children) {
      postHelper(node,res);
    }
    res.add(root.val);
  }

  /**
   * N-ary Tree Postorder Traversal -- Iterative
   * @see <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">Leetcode Link</a>
   */
  public List<Integer> postorderIterative(NaryTreeNode root) {
    if (root == null) return Collections.emptyList();
    List<Integer> res = new ArrayList<>();
    Deque<NaryTreeNode> stack = new LinkedList<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      NaryTreeNode node = stack.pop();
      res.add(node.val);
      for (NaryTreeNode child : node.children ) {
          stack.push(child);
      }
    }
    Collections.reverse(res);
    return res;
  }
  /**
   * N-ary Tree Postorder Traversal -- Iterative
   * @see <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">Leetcode Link</a>
   */
  public List<Integer> preorderIterative(NaryTreeNode root) {
    if (root == null) return Collections.emptyList();
    List<Integer> res = new ArrayList<>();
    Deque<NaryTreeNode> stack = new LinkedList<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      NaryTreeNode node = stack.pop();
      res.add(node.val);
      // push child from right to left
      for(int i = node.children.size()-1; i >= 0 ; i--) {
        stack.push(node.children.get(i));
      }
    }
    return res;
  }
  /**
   * N-ary Tree Postorder Traversal -- Recursive
   * @see <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">Leetcode Link</a>
   */
  public List<Integer> preorderRecursive(NaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorderHelper(root,res);
    return res;
  }

  private void preorderHelper(NaryTreeNode root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    for (NaryTreeNode node : root.children ) {
        preorderHelper(node,res);
    }
  }

  /**
   * Given an n-ary tree, return the level order traversal of its nodes' values.
   *
   * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">Leetcode
   *     Link</a>
   */
  public List<List<Integer>> levelOrder(NaryTreeNode root) {
    if (root == null) return Collections.emptyList();
    List<List<Integer>> res = new ArrayList<>();
    Queue<NaryTreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        NaryTreeNode node = queue.poll();
        currentLevel.add(node.val);
        queue.addAll(node.children);
      }
      res.add(currentLevel);
    }
    return res;
  }
}
