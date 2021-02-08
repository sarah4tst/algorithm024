import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class BinaryTreeNode {

  int val;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode() {
  }

  BinaryTreeNode(int val) {
    this.val = val;
  }

  BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class BinaryTreeTraversal {

  /**
   * Inorder Traversal - Iterative solution
   *
   * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">LeetCode Link</a>
   */
  public List<Integer> inorderTraversalIterative(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<BinaryTreeNode> stack = new LinkedList<>();

    BinaryTreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        // push left to the stack
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }

  /**
   * Inorder Traversal - Recursive solution
   * @see <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">LeetCode Link</a>
   */
  public List<Integer> inorderTraversalRecursive(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorderHelper(root, res);
    return res;
  }

  /**
   * Preorder Traversal - Recursive solution
   * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode Link</a>
   */
  public List<Integer> preorderTraversalIterative(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<BinaryTreeNode> stack = new LinkedList<>();
    BinaryTreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        res.add(curr.val);
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      curr = curr.right;
    }
    return res;
  }

  /**
   * Preorder Traversal - Recursive solution
   * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">LeetCode Link</a>
   */
  public List<Integer> preorderTraversalRecursive(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorderHelper(root,res);
    return res;
  }

  /**
   * Postorder Traversal - Iterative solution
   * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LeetCode Link</a>
   */
  public List<Integer> postorderTraversalIterative(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<BinaryTreeNode> stack = new LinkedList<>();
    BinaryTreeNode curr = root;
    BinaryTreeNode prev = null;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      if (curr.right == null || curr.right == prev) {
        // 访问节点的条件：1. 叶子结点；2. 当前结点的右结点为刚访问过的结点
        res.add(curr.val);
        prev = curr; // 记录刚才结点为刚访问过的结点
        curr = null; // 使下一步循环直接pop元素
      } else {
        //压回并处理右子树
        stack.push(curr);
        curr = curr.right;
      }
    }
    return res;
  }

  /**
   * Postorder Traversal - Recursive solution
   * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">LeetCode Link</a>
   */
  public List<Integer> postorderTraversalRecursive(BinaryTreeNode root) {
    List<Integer> res = new ArrayList<>();
    postOrderHelper(root,res);
    return res;
  }

  private void postOrderHelper(BinaryTreeNode root, List<Integer> res) {
    if (root == null) return;
    postOrderHelper(root.left, res);
    postOrderHelper(root.right, res);
    res.add(root.val);
  }

  private void preorderHelper(BinaryTreeNode root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    preorderHelper(root.left, res);
    preorderHelper(root.right, res);
  }

  private void inorderHelper(BinaryTreeNode root, List<Integer> res) {
    if (root == null) return;
    inorderHelper(root.left, res);
    res.add(root.val);
    inorderHelper(root.right, res);
  }
}
