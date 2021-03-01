/**
 * 33. 搜索旋转排序数组
 */
public class Search {

  public static void main(String[] args) {
    //
    Search test = new Search();
    System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
  }

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0, right = nums.length - 1, mid;

    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      // 前半部分有序(无序在右边，与Find中找折断点对应)
      if (nums[mid] > nums[right]) {
        // 若 target 在前半部分范围
        if (target >= nums[left] && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (target <= nums[right] && target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }

      }
    }
    return -1;
  }
}
