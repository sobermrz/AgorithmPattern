import java.util.Arrays;

// Problem Statement #
// Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

// Example 1:

// Input: [-2, 0, 1, 2], target=2
// Output: 1
// Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
// Example 2:

// Input: [-3, -1, 1, 2], target=1
// Output: 0
// Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
// Example 3:

// Input: [1, 0, 1, 1], target=100
// Output: 3
// Explanation: The triplet [1, 1, 1] has the closest sum to the target.


public class TripletSumCloseToTarget {
  //1. use pointer i to loop the array, and use left and right to start from the i + 1 and end
  //of the array
  //2. calculate the difference between target and them.
  //3. if the difference equals to 0, then return target - difference
  //4. record the smallest difference: if the difference less than smallest difference(both abs), 
  //then replace the smallest difference
  //5. if the difference larger than 0, then increase the left, or decrease the right
  //6. retutn target - difference\

  //Time: O(N^2): There are two part here. The first part is the sort function, and it is O(NlogN). The second part is the for loop and while loop
  //it is O(N^2), here N is the number of elements in the array. Thus the total is O(NlogN + N^2), which is asymptotically equivalent to O(N^2)
  //Space: O(N) This is for the sorting algorithm

  public static int searchTriplet(int[] arr, int target) {

    Arrays.sort(arr);
    int smallestDiff = Integer.MAX_VALUE;

    for(int i = 0; i < arr.length; i++){
      int left = i + 1;
      int right = arr.length - 1;

      while(left < right){
        int difference = target - arr[i] - arr[left] - arr[right];

        if(difference == 0){
          return target - difference;
        }

        if(Math.abs(difference) <  Math.abs(smallestDiff)){
          smallestDiff = difference;
        }

        if(difference > 0){
          left++;
        }else{
          right--;
        }
      }
    }

    return target - smallestDiff;
  }

  public static void main(String[] args) {
    int res1 = searchTriplet(new int[]{-2, 0, 1, 2}, 2);
    System.out.println(res1);

    int res2 = searchTriplet(new int[]{-3, -1, 1, 2}, 1);
    System.out.println(res2);

    int res3 = searchTriplet(new int[]{1, 0, 1, 1}, 100);
    System.out.println(res3);


  }
}
