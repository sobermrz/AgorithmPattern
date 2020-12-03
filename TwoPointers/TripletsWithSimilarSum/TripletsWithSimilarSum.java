import java.util.Arrays;

// Problem Statement #
// Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

// Example 1:

// Input: [-1, 0, 2, 3], target=3 
// Output: 2
// Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
// Example 2:

// Input: [-1, 4, 2, 1, 3], target=5 
// Output: 4
// Explanation: There are four triplets whose sum is less than the target: 
//    [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

public class TripletsWithSimilarSum {
  //1. sort arrays
  //2. use three pointer: first pointer to iterate the array, and other left and right pointer to move
  //from index i + 1 and end of the array
  //3. if sum is less than target, then count += right - left, also the left should increase; or decrease the right pointer

  //Time: O(N^2)
  //Space： O(N)

  public static int searchTriplets(int[] arr, int target) {
    Arrays.sort(arr);    
    int count = 0;

    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1;
      int right = arr.length - 1;
      while(left < right){
        int sum = arr[i] + arr[left] + arr[right];
        if(sum < target){
          //so right pointer can come across all positions less than it
          count += right - left;
          left++;
        }else{
          right--;
        }
      }
    }
    return count;
  }
  public static void main(String[] args) {
    int res1 = searchTriplets(new int[]{-1, 0, 2, 3}, 3);
    System.out.println(res1);

    int res2 = searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5);
    System.out.println(res2);
  }
}
