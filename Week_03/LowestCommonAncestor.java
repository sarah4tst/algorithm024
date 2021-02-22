/**
 * 236. 二叉树的最近公共祖先
 *
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">Leetcode
 * Link</a>
 */
public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    // 分在左右子树
    if (left != null && right != null) {
      return root;
    }
    //仅在某一子树
    return left != null ? left : right;
  }
}
