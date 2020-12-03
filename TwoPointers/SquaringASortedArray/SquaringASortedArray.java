// Problem Statement #
// Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

// Example 1:

// Input: [-2, -1, 0, 2, 3]
// Output: [0, 1, 4, 4, 9]
// Example 2:

// Input: [-3, -1, 0, 1, 2]
// Output: [0 1 1 4 9]

public class SquaringASortedArray {
  //1. left pointer begin at the start of the array and move forward. Right pointer begin at the right of the array
  // and move backward until left pointer meets the right one
  //2. compare the element square of the two pointer pointed, put the larger one on the array(from the end to the begin), then
  //move the larger pointer to the next position
  //3. return the result array
  public static int[] makeSquares(int[] arr) {
    int len = arr.length;
    int[] res = new int[len];

    int left = 0;
    int right = len - 1;

    while(left < right){
      //compare the square
      int leftSqaure = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];
      if(leftSqaure < rightSquare){
        res[len - 1] = rightSquare;
        right--;
      }else{
        res[len - 1] = leftSqaure;
        left++;
      }
      len--;
    }

    return res;
  }
  public static void main(String[] args) {
    int[] res1 = makeSquares(new int[]{-2, -1, 0, 2, 3});
    // System.out.println(res1);
    for (int i : res1) {
      System.out.print(i + " ");
    }
    System.out.println();
    int[] res2 = makeSquares(new int[]{-3, -1, 0, 1, 2});
    for (int i : res2) {
      System.out.print(i + " ");
    }
  }
  
}
