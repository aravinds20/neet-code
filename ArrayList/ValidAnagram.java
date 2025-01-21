package ArrayList;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Problem statement - Find if two strings are an anagram.
 */
public class ValidAnagram {

  public static void main(String[] args) {
    String str1 = "tar";
    String str2 = "rat";
    Map<String, Long> map1 = getMap(str1);
    Map<String, Long> map2 = getMap(str2);
    map1.entrySet().forEach(e-> System.out.print("key - "+e.getKey()+" value - "+e.getValue()));
    System.out.println(map1.equals(map2));
  }

  /*
  Approach - brute force.
  Space complexity - o(n^2)
  Time complexity - o(n^2)
   */
  private static Map<String, Long> getMap(String str2) {
    return Arrays.stream(str2.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
