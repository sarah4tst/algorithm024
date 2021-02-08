import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Top K Frequent Elements
 *
 * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/">Leetcode Link</a>
 */
public class TopKFrequentElements {

  public int[] topKFrequentHeap(int[] nums, int k) {
    // 1. 建立每个元素出现次数的hashmap
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int n : nums) {
      countMap.put(n, countMap.getOrDefault(n, 0) + 1);
    }

    // 2. 遍历hashmap，同时维护一个大小为k的堆
    Queue<Integer> heap = new PriorityQueue<>(k, (n1, n2) -> countMap.get(n1) - countMap.get(n2));
    for (int n : countMap.keySet()) {
      if (heap.size() < k) {
        heap.add(n);
      } else if (countMap.get(n) > countMap.get(heap.peek())) {
        heap.remove();
        heap.add(n);
      }
    }

    // 3. 输出小顶堆结果
    return heap.stream().mapToInt(Integer::intValue).toArray();
  }
}
