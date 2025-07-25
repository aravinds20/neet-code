package ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Validate if a given string is an anagram.
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class ValidAnagram {

  public static void main(String[] args) {
    String str1 = "anagram";
    String str2 = "nagaram";

    Map<String, Long> map1 = getCharCount(str1);
    Map<String, Long> map2 = getCharCount(str2);
    System.out.println(map1.equals(map2));

    char[] charArray = str1.toCharArray();
    Arrays.sort(charArray);
    System.out.println(isAnagramUsingHashMap(str1, str2));
    System.out.println(isAnnaGram(str1, str2));
  }

  private static Map<String, Long> getCharCount(String str) {
    return Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  private static boolean isAnagramUsingHashMap(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    for(char character : s1.toCharArray()){
      map.put(character, map.getOrDefault(character, 0)+1);
    }
    for(char character : s2.toCharArray()){
      map.put(character, map.getOrDefault(character, 0)-1);
    }
    for(var entry : map.entrySet()){
      if(entry.getValue()!=0)
        return false;
    }
    return true;
  }



  /**
   * [Expected Approach 2] Using Frequency Array - O(n) Time and O(1) Space
   * Instead of using a hash map to store the frequency of each character, we can create a frequency array of size 26
   * by using characters as index in this array. The frequency of ‘a’ is going to be stored at index 0, ‘b’ at 1,
   * and so on. To find the index of a character, we subtract character a’s ASCII value from the ASCII value of the character.
   *
   * Count character frequency in the first string, then for each character in the second string, decrement its count from the frequency array. If the strings are anagrams, all positions in the frequency array will be zero. Any non-zero position means the frequency of that character is not equal in both the strings
   * @param s1
   * @param s2
   * @return boolean
   */
  private static boolean isAnnaGram(String s1, String s2) {
    int[] freq = new int[26];
    char[] s1Arr = s1.toCharArray();
    char[] s2Arr = s2.toCharArray();
    //count the frequency of each character in string s1.
    for(char c : s1Arr) {
      freq[c-'a']++;
    }
    //subtract the frequency of each character in string s2 that was found in s1.
    for(char c : s2Arr) {
      freq[c-'a']--;
    }
    //check if the frequencies are equal
    for(int count : freq) {
      if(count != 0)
        return false;
    }
    return true;
  }
}
