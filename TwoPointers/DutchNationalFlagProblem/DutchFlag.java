// Problem Statement #
// Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.

// The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists of three different numbers that is why it is called Dutch National Flag problem.

// Example 1:

// Input: [1, 0, 2, 1, 0]
// Output: [0 0 1 1 2]
// Example 2:

// Input: [2, 2, 0, 1, 2, 0]
// Output: [0 0 1 2 2 2 ]

public class DutchFlag {
  //1. use two pointer, left and right. Then iterate the array
  //if the numebr is 0, then swap it with the left pointer number, then left increase
  //if the number is 2, then swap it with the right pointer number, then right decrease

  public static void sort(int[] arr) {
    //Time: O(N)
    //Space: O(1)
    int left = 0;
    int right = arr.length - 1;

    for(int i = 0; i <= right;){
      if(arr[i] == 0){
        swap(arr, i, left);
        i++;
        left++;
      }else if(arr[i] == 2){
        swap(arr, i, right);
        right--;
      }else{
        i++;
      }
    }
  }

  public static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
  

  public static void main(String[] args) {
    // int[] arr = new int[]{1, 0, 2, 1, 0};
    // sort(arr);
    // for (int i = 0; i < arr.length; i++) {
    //   System.out.println(arr[i]);
    // }

    // System.out.println("========");

    int[] arr1 = new int[]{2, 2, 0, 1, 2, 0};
    sort(arr1);
    for (int i = 0; i < arr1.length; i++) {
      System.out.println(arr1[i]);
    }
  }
}
