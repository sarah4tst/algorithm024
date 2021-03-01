import java.util.Arrays;

public class FindContentChildren {

  /**
   * 455. 分发饼干
   */
  public static void main(String[] args) {
    //
    FindContentChildren test = new FindContentChildren();
    System.out.println(test.findContentChildren(
        new int[]{1, 2, 3},
        new int[]{1, 1}
    ));
  }

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int res = 0;
    for (int i = 0; i < s.length; i++) {
      //饼干满足当前小孩需求
      if (s[i] >= g[res]) {
        res++;
      }
      //已经找不到满足需求的小孩
      if (res == g.length) {
        break;
      }
    }
    return res;
  }
}
