学习笔记
# 模板
## 递归模板
```
private void recur(level, params) {
  // 1. terminator
  if (level > MAX_LEVEL) {
    process_result();
    return;
  }
  // 2. prepare data
  prepare_data(parmas);
  // 3. drill down
  recur(level+1, newParams);
  // 4. restore current status
  restore(params);
}
```
## 分治模板
```
private void divide_conquer(problem, params) {
  // 1. terminator    
  if (problem == NULL) {    
    process_last_result();    
    return;       
  }  

  // 2. prepare data
  data = prepare_data(problem)
  subProblems = split_problem(problem, data);
  
  // 3. drill down
  // 3.1 (conquer subproblems)
  subresult0 = divide_conquer(subProblems[0]);
  subresult1 = divide_conquer(subProblems[1]); 
  ...
   
  // 3.2 process and generate the final result for current level.(merge subresults)
  result = process_result(res0, res1);    

  // 4. restore current level status
  restore(params);
}
```
## 组合
对于个人来说，分解为选与不选的思路更容易理解。**记得解枝**判断
## 全排列
***目前仅能用一种比较简单与通用的模板来解决问题，还未消化网上其它比较巧妙的解法区分情况获取更优的复杂度***
### 待完成项
网上针对有重复元素（通过排序，与不通过排序）与无重复元素的方案，以及针对结果集是否按做任意顺序返回，个人还得继续从中选出适合自己理解与有共性的方法

# 思维要点
1. 不要人肉递归
2. 找最近重复子问题
3. 数学归纳法
# 难点
找状态定义与状态转移方程
# 踩过的坑
- 验证BST的时候，数值边界处理，以及比较的时候=处理
- 二叉树的最小深度：递归条件写错（当左或右子树存在的时候，返回大值；当左右子树都存在的时候，返回小值）
# 本周作业
-[x] 二叉树的最近公共祖先（Facebook 在半年内面试常考）
-[ ] 从前序与中序遍历序列构造二叉树（字节跳动、亚马逊、微软在半年内面试中考过）
-[x] 组合（微软、亚马逊、谷歌在半年内面试中考过）
-[x] 全排列（字节跳动在半年内面试常考）
-[x] 全排列 II （亚马逊、字节跳动、Facebook 在半年内面试中考过）
# 本周实战题目
-[ ] 多数元素 （亚马逊、字节跳动、Facebook 在半年内面试中考过）
-[x] 电话号码的字母组合（亚马逊在半年内面试常考）
-[ ] N 皇后（字节跳动、苹果、谷歌在半年内面试中考过）
-[x] Pow(x, n) （Facebook 在半年内面试常考）
-[ ] 子集（Facebook、字节跳动、亚马逊在半年内面试中考过）
-[x] 爬楼梯（阿里巴巴、腾讯、字节跳动在半年内面试常考）
-[x] 括号生成 (字节跳动在半年内面试中考过)
-[x] 翻转二叉树 (谷歌、字节跳动、Facebook 在半年内面试中考过)
-[x] 验证二叉搜索树（亚马逊、微软、Facebook 在半年内面试中考过）
-[x] 二叉树的最大深度（亚马逊、微软、字节跳动在半年内面试中考过）
-[x] 二叉树的最小深度（Facebook、字节跳动、谷歌在半年内面试中考过）
-[x] 二叉树的序列化与反序列化（Facebook、亚马逊在半年内面试常考）
