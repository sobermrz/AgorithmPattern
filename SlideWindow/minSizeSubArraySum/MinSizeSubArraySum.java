import java.*;
// Problem Statement #
// Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

// Example 1:

// Input: [2, 1, 5, 2, 3, 2], S=7 
// Output: 2
// Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
// Example 2:

// Input: [2, 1, 5, 2, 8], S=7 
// Output: 1
// Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
// Example 3:

// Input: [3, 4, 1, 1, 6], S=8 
// Output: 3
// Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].

class MinSizeSubArraySum{
  public static int findMinSubArray(int s, int[] arr) {
    // 1. dynamic increase the size of window, until the sum of window equals or larger than s
    // 2. mark the length of current window, and compare it with the variables minLen
    // 3. deduct the first element of the window, repeat step 1 and step 2 until current window sum less than s
    // 4. add the next element into the window
    int windowSum = 0;
    int windowStart = 0;
    int minLen = Integer.MAX_VALUE;

    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      windowSum += arr[windowEnd];

      while(windowSum >= s){
        // store the len of current window
        int len = windowEnd - windowStart + 1;
        minLen = Math.min(minLen, len);

        //deduct the first element of the window, until sum of window less than s
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return minLen;
  }
  public static void main(String[] args) {
    int res1 = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
    System.out.println(res1);

    int res2 = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
    System.out.println(res2);

    int res3 = MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
    System.out.println(res3);
  }
}