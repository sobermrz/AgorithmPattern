import java.util.Arrays;

// Problem Statement #
// Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

// Example 1:

// Input: [2, 3, 3, 3, 6, 9, 9]
// Output: 4
// Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
// Example 2:

// Input: [2, 2, 2, 11]
// Output: 2
// Explanation: The first two elements after removing the duplicates will be [2, 11].

public class PairWithTargetSum {
  //Time: O(N) here the N is the length of the array 
  //Space: O(1)  
  public static int[] search(int[] arr, int targetSum) {

    int firstPointer = 0;
    int lastPointer = arr.length - 1;

    int[] res = new int[] {-1, -1};

    while(firstPointer < lastPointer){
      int sum = arr[firstPointer] + arr[lastPointer];

      if(sum == targetSum){
        res[0] = firstPointer;
        res[1] = lastPointer;
        break;
      }

      if(sum < targetSum){
        firstPointer++;
      }else{
        lastPointer--;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] res1 = search(new int[] {1,2,3,4,6}, 6);
    System.out.println(res1[0] + res1[1]);

    int[] res2 = search(new int[] {2,5,9,11}, 11);
    System.out.println(res2[0] + res2[1]);
  }
}
