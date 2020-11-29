// Problem Statement #
// Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

// Example 1:

// Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
// Output: 6
// Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
// Example 2:

// Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
// Output: 9
// Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

public class ReplacingOnes {
  //1. add number from arr into slide window, when the number is 0, use cnt to count
  //how many 0 has been added into the window
  //2. calculate the length of the window
  //3. when cnt is larger than k, and adding number equals to 0, then remove number from the start of the window until the 
  //removed number is 0, also cnt--;
  //4. repeat steps above
  public static int findLength(int k, int[] arr){
    int cnt = 0;
    int maxLen = Integer.MIN_VALUE;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      int num = arr[windowEnd];

      if(num == 0) cnt++;

      if(cnt <= k){
        int len = windowEnd - windowStart + 1;
        maxLen = Math.max(maxLen, len);
      }

      while(cnt > k && num == 0){
        if(arr[windowStart] == 0){
          cnt--;
        }
        windowStart++;
      }
    }

    return maxLen;
  }
  public static void main(String[] args) {
    int res1 = ReplacingOnes.findLength(2, new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1});
    System.out.println(res1);

    int res2 = ReplacingOnes.findLength(3, new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1});
    System.out.println(res2);

    int res3 = ReplacingOnes.findLength(2, new int[]{0, 0, 0, 0, 0});
    System.out.println(res3);
  }
}
