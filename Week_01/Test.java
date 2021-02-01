public class Test {
  public static void main(String[] args) {
    //
    MoveZeroes solutions = new MoveZeroes();
    int[] nums = new int[] {0,1,2};
    solutions.moveZeroes(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + ",");
    }
  }
}
