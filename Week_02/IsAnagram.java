import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * @see <a href="https://leetcode.com/problems/valid-anagram/description/">Leetcode Link</a>
 */
public class IsAnagram {

  // Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
  public boolean isAnagramExpand(String s, String t) {
    if (s.length() != t.length()) return false;
    Map<Character,Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
        map.put(c,map.getOrDefault(c,0)+1);
    }
    for (Character c : t.toCharArray()) {
      int count = map.getOrDefault(c,0);
      if (count > 0) {
        map.put(c,count - 1);
      } else {
        return false;
      }
    }
    return true;
  }

  // the string contains only lowercase alphabets.
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
    for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
    for (int i : alphabet) if (i != 0) return false;
    return true;
  }
}
