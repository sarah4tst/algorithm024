public class Find {

  /**
   * 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
   *
   * @param args
   */
  public static void main(String[] args) {
    //
    Find find = new Find();
    System.out.println(find.find(new int[]{
        5, 5, 6, 7, 0, 1, 2, 3, 3
    }));
  }

  public int find(int[] nums) {
    int left = 0, right = nums.length - 1;
    if (nums == null || nums.length == 0 || nums[left] < nums[right]) {
      return -1; //无效输入或者数组有序直接返回
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        // 无序在右边
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
