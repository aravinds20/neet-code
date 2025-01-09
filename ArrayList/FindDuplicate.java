/**
 * Contains Duplicate
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [1, 2, 3, 3]
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 *
 * Output: false
 * 
 */

package ArrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FindDuplicate {

  public static void main(String[] args) {

    int nums[] = {12, 3, 1, 4, 5, 6, 67,6};
    System.out.println(hasDuplicateV1(nums));
    System.out.println(hasDuplicateV2(nums));
    System.out.println(hasDuplicateV3(nums));
    System.out.println(hasDuplicateV4(nums));

  }

  //Brute force -
  //Time complexity - O(n^2)
  //Space complexity - O(1)
  public static boolean hasDuplicateV1(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j])
          return true;
      }
    }
    return false;
  }

  //Sorting -
  //Time complexity - n(logn) - depending on the sort and the number, we might reject some part of the array.
  //Space complexity - O(1) or O(n) depending on the sorting algorithm.
  public static boolean hasDuplicateV2(int[] nums) {
    Arrays.sort(nums);
    for(int i=1;i<nums.length;i++){
      if(nums[i]==nums[i-1])
        return true;
    }
    return false;
  }

  //Hashet -
  //Time complexity - O(n)
  //Space complexity - O(n)
  public static boolean hasDuplicateV3(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(Integer n : nums) {
      if(!set.add(n))
        return true;
    }
    return false;
  }

  //Hash set length
  //Time complexity - O(n)
  //Space complexity - O(n)
  public static boolean hasDuplicateV4(int[] nums) {
    if(Arrays.stream(nums).distinct().count()<nums.length)
      return true;
    else
      return false;
  }
}
