/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {

  public static void main(String[] args) {
    //
    FindMin test = new FindMin();
    System.out.println(test.findMin(new int[]{3, 4, 5, 1, 2}));
  }

  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1, mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      // 右无序
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        // mid 可能是最小值
        right = mid;
      }
    }
    return nums[left];
  }
}
