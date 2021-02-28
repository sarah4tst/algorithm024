import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {

  public static void main(String[] args) {
    GenerateParenthesis sol = new GenerateParenthesis();
    System.out.println(sol.generateParenthesis(3));
  }

  public List<String> generateParenthesis(int n) {
    if (n <= 0) {
      return Collections.emptyList();
    }
    List<String> res = new ArrayList<>();
    generateHelper(0, 0, "", n, res);
    return res;
  }

  private void generateHelper(int left, int right, String seeds, int n, List<String> res) {
    if (left == n && right == n) {
      res.add(seeds);
      return;
    }

    // 添加左括号
    if (left < n) {
      generateHelper(left + 1, right, seeds + "(", n, res);
    }
    // 添加右括号
    if (left > right) {
      generateHelper(left, right + 1, seeds + ")", n, res);
    }
  }
}
