import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Anagram {

  /**
   * Given an array of strings strs, group the anagrams together.
   *
   * @param strs an array of strings
   * @return
   * @see <a href="https://leetcode-cn.com/problems/group-anagrams/">Leetcode Link</a>
   */
  public List<List<String>> groupAnagramsBySort(String[] strs) {
    // time: O(n*klogk), n: strs 的个数 , klogk 为每个字串排序所用的时间复杂度
    // space: O(nk).
    // 代码可适用于非小写字母及其它字母的场景
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] sArray = s.toCharArray();
      Arrays.sort(sArray);
      map.computeIfAbsent(String.valueOf(sArray), k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
  }

  public List<List<String>> groupAnagramsByCount(String[] strs) {
    // time: O(nk), n: strs 的个数
    // space: O(nk)
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String s : strs) {
      int[] arr = new int[26];
      for (int i = 0; i < s.length(); i++) {
        arr[s.charAt(i) - 'a']++;
      }
      map.computeIfAbsent(Arrays.toString(arr), k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
  }

  /**
   * Given two strings s and t, write a function to determine if t is an anagram of s.
   *
   * @see <a href="https://leetcode.com/problems/valid-anagram/description/">Leetcode Link</a>
   */
  // Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
  public boolean isAnagramHashMap(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      map.merge(c, 1, Integer::sum);
    }
    for (Character c : t.toCharArray()) {
      map.merge(c, -1, Integer::sum);
      if (map.get(c) == -1) {
        return false;
      }
    }
    return true;
  }

  // the string contains only lowercase alphabets.
  public boolean isAnagramByCounting(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabet[s.charAt(i) - 'a']++;
      alphabet[t.charAt(i) - 'a']--;
    }
    for (int n : alphabet) {
      if (n != 0) {
        return false;
      }
    }
    return true;
  }

  // Sort strings, then compare. O(nlogn)
  // case sensitive
  public boolean isAnagramBySorting(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);
    return Arrays.equals(sArray, tArray);
  }

}
