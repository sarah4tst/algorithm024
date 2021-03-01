public class LemonadeChange {

  public static void main(String[] args) {
    LemonadeChange test = new LemonadeChange();
    System.out.println(test.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
  }

  /**
   * 860. 柠檬水找零
   */
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
      if (bill == 5) {
        five++;
      } else if (bill == 10) {
        five--;
        ten++;
      } else if (ten > 0) {
        // 支付20，找零15时，优先找10+5
        ten--;
        five--;
      } else {
        // 支付20，找零15时（3个5）
        five -= 3;
      }
      if (five < 0) {
        return false;
      }
    }
    return true;
  }
}
