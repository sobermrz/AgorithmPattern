// Problem Statement #
// Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

// Example 1:

// Input: [2, 1, 5, 1, 3, 2], k=3 
// Output: 9
// Explanation: Subarray with maximum sum is [5, 1, 3].
// Example 2:

// Input: [2, 3, 4, 1, 5], k=2 
// Output: 7
// Explanation: Subarray with maximum sum is [3, 4].

class MaxSumSubArrayOfSizeK{
  public static int findMaxSumSubArray(int k, int[] arr) {
    //1. dynamic change the slide window
    //2. use slide window to calculate the sum of window, when the size of the window is k
    //3. store the sum of the window and compare with the size stored in variable maxSum

    //corner case
    if(k > arr.length) return 0;

    int windowSum = 0;
    int windowStart = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      windowSum += arr[windowEnd];

      if(windowEnd >= k - 1){
        maxSum = Math.max(maxSum, windowSum);
        // System.out.println(maxSum + windowSum);
        //deduct the first one
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int res1 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{3, 1, 5, 1, 3, 2});
    System.out.println(res1);

    int res2 = MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
    System.out.println(res2);
  }
}