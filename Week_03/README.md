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
## backtrace模板
backtrace：对于构建时决策树，涉及三个概念:
1. 路径 （已经做出的选择）
2. 选择列表 （当前可做出的选择）
3. 结束条件 
```
for 选择 in 选择列表:
    # 做选择
    track.add(该选择项）
    path.add(选择)
    backtrack(路径, 选择列表)
    # 撤销选择
    path.remove(选择)
    track.remove(该选择项)
```
## 组合
backtrace 方法解决 
1. 根据搜索起点画决策树
```
private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
```
2. 根据选与不选画决策树
```
    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 基础版本的递归终止条件：if (begin == n + 1) {
        if (begin > n - k + 1) {
            return;
        }
        // 不选当前考虑的数 begin，直接递归到下一层
        dfs(begin + 1, n, k, path, res);

        // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
        path.addLast(begin);
        dfs(begin + 1, n, k - 1, path, res);
        // 深度优先遍历有回头的过程，因此需要撤销选择
        path.removeLast();
    }
```
## 全排列
1. backtrace 方法解决：引入visited数组辅助
```
void backtrack(int[] nums, boolean[] used) {
    for (int i = 0; i < nums.length; i++) {
        // 如果数字已经被选择了，就剪枝不做处理了
        if (used[i]) {
            continue;
        }

        // 前序遍历
        // 在这里做选择，选择 nums[i]
        used[i] = true;
        backtrack(nums, used)

        // 后序遍历
        // 在这里恢复状态
        used[i] = false;
    }
}

```
2. 基于交换
把已经选择的这个元素换到前边去，比如 level=0 所在的位置，那下一次选择的时候从 level=1 开始处理，level=0 我们选择过了，同时这个被选择的
元素已经放在了 i=0 的位置，确实是我们想要的，这样依次下去，直到 level == nums.length，得到结果，回溯到上一层，再继续处理。

注意：当我们处理完所有的层，nums 数组中存储的元素就是我们需要的结果。 --- 故：会改变原数组
```
// param: level 记录处理到了哪一层
    private void backtrack(List<List<Integer>> res, int[] nums, int level) {
        // 终止条件：已经到了最后一层
        if (nums.length == level) {
            List<Integer> r = new ArrayList<>();
            for (int num : nums) {
                r.add(num);
            }
            // 保存结果
            res.add(r);
            return;
        }

        // 注意这里 i = level
        for (int i = level; i < nums.length; i++) {
            // 前序遍历，进入到下一层之前做些事情
            // 交换元素
            int tmp = nums[level];
            nums[level] = nums[i];
            nums[i] = tmp;

            backtrack(res, nums, level + 1);

            // 后序遍历，退出后做一些事情
            // 恢复交换的元素
            tmp = nums[level];
            nums[level] = nums[i];
            nums[i] = tmp;
        }
    }
```
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
