import java.util.HashMap;

// Problem Statement #
// Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

// You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

// Write a function to return the maximum number of fruits in both the baskets.

// Example 1:

// Input: Fruit=['A', 'B', 'C', 'A', 'C']
// Output: 3
// Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
// Example 2:

// Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
// Output: 5
// Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
// This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

//Time: O(N) The time complexity should be O(N), here the N equals to the number of characters in the input string. 
//Outter for loop run for N times and inner while loop process each character only once, therefor the time complexity
//of the algorithm will be O(N + N) which is asymoptotially equivalent to O(N)
//Space: O(1) The space complexity should be O(1) since the size of HashMap was limited 3(at most it can put 3 different characters)
//and it was not influenced by k, thus it should be a constant time space.

public class MaxFruitCountOf2Type {
  //1. add element into slide window, until the window has more than 2 types of characters
  //also, use HashMap to store the character and its frequence
  //2. deduct the first characrter and its frequence in the HashMap until the size of HashMap
  //no more than 2
  //3. store the maxLen of the window
  public static int length(char[] arr) {
    HashMap<Character, Integer> map = new HashMap<>();
    int windowStart = 0;
    int maxLen = Integer.MIN_VALUE;
    //add element into the slide window
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
      char c = arr[windowEnd];
      map.put(c, map.getOrDefault(c, 0) + 1);
      //resize the window
      while(map.size() > 2){
        char removedChar = arr[windowStart];
        map.put(removedChar, map.get(removedChar) - 1);
        //if its frequence equals to 0, then remove the character
        if(map.get(removedChar) == 0){
          map.remove(removedChar);
        }
        windowStart++;
      }
      //get the max length of the window
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
    }

    return maxLen;
  }
  public static void main(String[] args) {
    System.out.println(MaxFruitCountOf2Type.length(new char[]{'A', 'B', 'C', 'A', 'C'}));
    System.out.println(MaxFruitCountOf2Type.length(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
  }
}
