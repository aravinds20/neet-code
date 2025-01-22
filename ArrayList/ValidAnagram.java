package ArrayList;

import java.util.Arrays;
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
    String s = new String(charArray);
  }

  private static Map<String, Long> getCharCount(String str) {
    return Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }


}
