// Problem Statement #
// Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

// Example 1:

// Input: [2, 3, 3, 3, 6, 9, 9]
// Output: 4
// Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
// Example 2:

// Input: [2, 2, 2, 11]
// Output: 2
// Explanation: The first two elements after removing the duplicates will be [2, 11].

public class RemoveDupilcates {
  //1. use two pointer: nonDuplicate, next. starting from the first element of the array
  //2. use next to iterate the array, when the element equals to nonDuplicate, move to the next;
  //else, move the element to nonDuplicate and nonDuplicate move to the next position
  //3. return to the noDuplicate

  //Time: O(N) Since we iterate the array, so time complexity is O(N). Here N is the number of elements in the array
  //Space: O(1)

  public static int remove(int[] arr){
    // int nonDuplicate = 0;
    // int next = 1;
    // while(next < arr.length){
    //   if(arr[next] == arr[nonDuplicate]){
    //     next++;
    //   }else{
    //     nonDuplicate++;
    //     arr[nonDuplicate] = arr[next];
    //     next++;
    //   }
    // }
    int nonDuplicate = 0;
    for (int i = 1; i < arr.length; i++) {
      if(arr[nonDuplicate] != arr[i]){
        nonDuplicate++;
        arr[nonDuplicate] = arr[i];   
      }
    }

    return nonDuplicate + 1;
  }
  
  public static void main(String[] args) {
    int res1 = remove(new int[]{2, 3, 3, 3, 6, 9, 9});
    System.out.println(res1);
    int res2 = remove(new int[]{2, 2, 2, 11});
    System.out.println(res2);
  }
}
