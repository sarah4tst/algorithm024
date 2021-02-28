import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

  private static Map<Character, String> letterMap = Map.of(
      '2', "abc",
      '3', "def",
      '4', "ghi",
      '5', "jkl",
      '6', "mno",
      '7', "pqrs",
      '8', "tuv",
      '9', "wxyz"
  );

  public static void main(String[] args) {
    LetterCombinations letterCombinations = new LetterCombinations();

    System.out.println(letterCombinations.letterCombinations("23"));
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return Collections.emptyList();
    }
    List<String> res = new LinkedList<>();
    search(digits, 0, "", res);
    return res;
  }

  private void search(String digits, int idx, String path, List<String> res) {
    if (idx == digits.length()) {
      res.add(path);
      return;
    }

    String letters = letterMap.getOrDefault(digits.charAt(idx), "");
    for (Character ch : letters.toCharArray()) {
      search(digits, idx + 1, path + ch, res);
    }
  }
}
