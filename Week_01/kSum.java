import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSum {

  public static void main(String[] args) {
    kSum test = new kSum();
    int[] nums = new int[] {
        -1,0,-5,-2,-2,-4,0,1,-2
//        -1,0,1,2,-1,-4
//        -2,-1,-1,1,1,2,2
//        1,0,-1,0,-2,2
    };
    System.out.println("result = " + test.fourSum(nums,-9));
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null || nums.length < 4) return new ArrayList<>();
    Arrays.sort(nums);
    return kSumHelper(nums,target,4,0,nums.length);
  }

  /**
   * 对已排序数组，找出从指定下标开始的k个元素总和==target
   */
  private List<List<Integer>> kSumHelper(int[] nums, int target, int k, int startIdx, int length) {
    if (k == 2) return twoSum(nums, target, startIdx, length-1);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = startIdx; i < length - k + 1; i++) {
      if (i > startIdx && nums[i] == nums[i-1]) continue; // 去重
      if ((nums[i] + nums[length-1] * (k-1)) < target) continue; // 剪枝
      if (nums[i] * k > target) break; // 剪枝
      List<List<Integer>> subList = kSumHelper(nums, target-nums[i],k-1,i+1, length);
      for (List<Integer> list: subList) list.add(nums[i]);
      res.addAll(subList);
    }
    return res;
  }

  private List<List<Integer>> twoSum(int[] nums, int target, int startIdx, int endIdx) {
    List<List<Integer>> res = new ArrayList<>();
    while (startIdx < endIdx) {
      int expected = target - nums[startIdx];
      if (expected == nums[endIdx]) {
        res.add(new ArrayList<>(Arrays.asList(nums[startIdx],nums[endIdx])));
        while (startIdx < endIdx && nums[startIdx] == nums[++startIdx]); // 去重
        while (startIdx < endIdx && nums[endIdx] == nums[--endIdx]); // 去重
      } else if (expected < nums[endIdx]) {
        endIdx--;
      } else {
        startIdx++;
      }
    }
    return res;
  }
}
