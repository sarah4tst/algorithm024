# 学习笔记
## 遍历
前/中/后序均为深度优先，用递归或stack实现
- 二叉树遍历用Stack实现时，几个注意点
1. 前序与中序（背诵)
```
while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        res.add(curr.val); //前序与中序仅在此句位置
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      curr = curr.right;
    }
```

2. 后序
记得遍历结点后（无右孩子或者右子树已经遍历过），prev=curr, curr=null
```
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
```
- N叉树前后序遍历 (递归/stack)
前序时，先加node，再将children从右到左push进stack
后序时，先加node，再将children从左到右push进stack -> 最终reverse 即为后序

```
    while (!stack.isEmpty()) {
      NaryTreeNode node = stack.pop();
      res.add(node.val);
      for (NaryTreeNode child : node.children ) {
          stack.push(child);
      }
    }
    Collections.reverse(res);
```
N叉树BFS，用queue实现

```
root为空，直接返回
root入Queue
while !queue.isEmpty
  取出当前queue中的所有元素,加入结果中
  将每个元素的所有children入Queue
```
## 堆
用于解决topK问题，Java中用PriorityQueue,自定义Comparator
# 本周作业
写一个关于 HashMap 的小总结
- [x] [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)
- [x] [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
- [x] [N 叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
- [x] [N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/)
- [x] [N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)
- [x] [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/) （亚马逊、Facebook、谷歌在半年内面试中考过）
- [x] HeapSort ：自学 https://www.geeksforgeeks.org/heap-sort/
- [x] [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) （亚马逊在半年内面试中常考）
- [x] [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) （亚马逊在半年内面试中常考）

