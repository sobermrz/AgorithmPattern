import java.util.Arrays;

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
        res[i++] = (double) sum / K;
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
