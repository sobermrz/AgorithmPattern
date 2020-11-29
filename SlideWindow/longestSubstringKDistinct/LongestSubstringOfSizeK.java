import java.util.HashMap;

// Problem Statement #
// Given a string, find the length of the longest substring in it with no more than K distinct characters.

// Example 1:

// Input: String="araaci", K=2
// Output: 4
// Explanation: The longest substring with no more than '2' distinct characters is "araa".
// Example 2:

// Input: String="araaci", K=1
// Output: 2
// Explanation: The longest substring with no more than '1' distinct characters is "aa".
// Example 3:

// Input: String="cbbebi", K=3
// Output: 5
// Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".


//Time: O(N) The time complexity should be O(N), here the N equals to the number of characters in the input string. 
//Outter for loop run for N times and inner while loop process each character only once, therefor the time complexity
//of the algorithm will be O(N + N) which is asymoptotially equivalent to O(N)
//Space: O(1) The space complexity should be O(1) since the size of HashMap was limited by the numbers of characters(26),
//and it was not influenced by k, thus it should be a constant time space.

//Time: O(N)
//Space: O(1)
public class LongestSubstringOfSizeK {
  //1. use a sliding window, and increase it until it has more k different characters.
  //meanwhile, use HashMap to count characters and its frequences
  //2. use loop to move one character from the start of the slide window, and also deduct 
  //it frequence on HashMap, until it has no more than k different characters in the slide window
  //3. count the length of slide window and store the longest length
  public static int findLength(int k, String s){
    StringBuilder window = new StringBuilder();
    HashMap<Character, Integer> map = new HashMap<>();
    int maxLen = Integer.MIN_VALUE;
    int windowStart = 0;

    for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
      //move the slide window until it has k characters
      char c = s.charAt(windowEnd);
      //use HashMap to store the character and its frequence
      map.put(c, map.getOrDefault(c, 0) + 1);
      //when the slide window has more than k elements
      while(map.size() > k){
        //adjust the slide window: move out the character from the start
        //deduct the frequence of the removed character. if the frequence is 0
        //then remove the character from HashMap
        char removedChar = s.charAt(windowStart);
        map.put(removedChar, map.get(removedChar) - 1);
        if(map.get(removedChar) == 0){
          map.remove(removedChar);
        }
        windowStart++;
      }
      //get the max length of the dynamic slide window
      int length = windowEnd - windowStart + 1;
      maxLen = Math.max(maxLen, length);

    }
    return maxLen;
  }
  

  public static void main(String[] args) {
    int res1 = LongestSubstringOfSizeK.findLength(2, "araaci");
    System.out.println(res1);

    int res2 = LongestSubstringOfSizeK.findLength(1, "araaci");
    System.out.println(res2);

    int res3 = LongestSubstringOfSizeK.findLength(3, "cbbebi");
    System.out.println(res3);
  }
}
