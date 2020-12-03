import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem Statement #
// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

// Example 1:

// Input: [-3, 0, 1, 2, -1, 1, -2]
// Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
// Explanation: There are four unique triplets whose sum is equal to zero.
// Example 2:

// Input: [-5, 2, -1, -2, 3]
// Output: [[-5, 2, 3], [-2, -1, 3]]
// Explanation: There are two unique triplets whose sum is equal to zero.

public class TripletSumToZero {

  //x + y + z == 0 => x + y == -z
  //1. sort the array
  //2. use a pointer to loop the arr, and current point to arr[i], then we use two pointer(left, right)
  //from i + 1 and the end of the arr to calculate the sum of them
  //3. if the sum > -arr[i], then decrement the right pointer; or decrement the left. if sum == arr[i],
  //then add the three number into list

  //Time: O(N^2): Here the sort function requires O(NlogN). When we loop the array, we need O(N) time complexity.
  //When we use left and right pointer, we also need O(N) time complexity. Since the while loop is in for loop, so
  //the time complexity is O(N * N). The totally time complexity is O(NlogN + N * N) which is asymptotically equals to O(N^2)
  //Space: O(N) The space complexity is O(N) which is required by sort function
  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> res = new ArrayList<>();

    //corner case
    if(arr.length == 0 || arr == null) return res;

    Arrays.sort(arr);

    for(int i = 0; i < arr.length - 2; i++){
      int left = i + 1;
      int right = arr.length - 1;
      int sum = -arr[i];

      while(left < right){
        if(arr[left] + arr[right] == sum){
          res.add(Arrays.asList(arr[i], arr[left], arr[right]));
          //there is other possible pairs
          left++;
          right--;
        }else if(arr[left] + arr[right] < sum){
          left++;
        }else{
          right--;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    List<List<Integer>> list1 = searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
    System.out.println(list1);
    List<List<Integer>> list2 = searchTriplets(new int[]{-5, 2, -1, -2, 3});
    System.out.println(list2);
  }
}
