package ArrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Given an array, find if it is a duplicate.
 */
public class FindDuplicate {

  public static void main(String[] args) {

    int[] arr = {1,2,3,4,5,6,7,3,2,1};
    System.out.println(isDuplicateV1(arr));
    System.out.println(isDuplicateV2(arr));
    System.out.println(isDuplicateV3(arr));
    System.out.println(isDuplicateV4(arr));
  }

  //  Time complexity - On^2
  //Space complexity - O(1)
  public static boolean isDuplicateV1(int[] arr) {
    for(int i = 0; i<arr.length;i++) {
      for(int j = i+1; j<arr.length;j++) {
        if(arr[i] == arr[j])
          return true;
      }
    }
    return false;
  }

  //Time complexity - O(nlogn)
  //Space complexity - O(1)
  public static boolean isDuplicateV2(int[] arr) {
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++){
      if(arr[i] == arr[i+1]) {
        return true;
      }
    }
    return false;
  }

  //Space complexity - O(n)
  //Time complexity - O(n)
  public static boolean isDuplicateV3(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for(Integer i : arr){
      if(!set.add(i)) {
        return true;
      }
    }
    return false;
  }

  //Space complexity - O(n)
  //Time complexity - O(n)
  public static boolean isDuplicateV4(int[] arr) {
    return Arrays.stream(arr).distinct().count()<arr.length;
  }

}
