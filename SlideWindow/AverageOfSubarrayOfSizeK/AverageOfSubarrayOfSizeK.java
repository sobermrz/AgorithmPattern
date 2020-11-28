// In many problems dealing with an array (or a LinkedList), we are asked to find or calculate something among all the contiguous subarrays (or sublists) of a given size. For example, take a look at this problem:

// Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

// Let’s understand this problem with a real input:

// Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
// Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:

// For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
// The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
// For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
// …
// Here is the final output containing the averages of all contiguous subarrays of size 5:

// Output: [2.2, 2.8, 2.4, 3.6, 2.8]
import java.util.*;
class AverageOfSubarrayOfSizeK {

  public static double[] findAverage(int K, int[] arr) {
    int windowSum = 0;
    int windowStart = 0;
    int i = 0;
    double[] res = new double[arr.length - K + 1];
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      //add the new element to the sum
      windowSum += arr[windowEnd];

      //adjust the window element when the size is more than K
      if (windowEnd >= K - 1) {
        res[i++] = (double) windowSum / K;
        //calculate the new sum
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // AverageOfSubarrayOfSizeK solution = new AverageOfSubarrayOfSizeK();
    // double[] res = solution.findAverage(5, new int[]{
    //   1, 3, 2, 6, -1, 4, 1, 8, 2
    // })
    double[] res = AverageOfSubarrayOfSizeK.findAverage(
      5,
      new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }
    );
    System.out.println(Arrays.toString(res));
  }
}
