import java.util.HashMap;

// Problem Statement #
// Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

// Example 1:

// Input: String="aabccbb", k=2
// Output: 5
// Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
// Example 2:

// Input: String="abbcb", k=1
// Output: 4
// Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
// Example 3:

// Input: String="abccde", k=1
// Output: 3
// Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

//Time: O(N) The time complexity equals to O(N), here the N equals to the length of the string
//Space: O(1) As we are expecting to store lower case letter as the key in the HashMap, so the max size of the 
//HashMap is O(26), which is asymptotically equals to O(1)
public class CharacterReplacement {
  //1. add letter into the sliding window, also use HashMap to record itself and frequence
  //2. get the max frequence of letter in the sliding window, let say maxFrequence
  //3. when the difference of length of sliding window and maxFrequence is less than k, it
  //means when can replace all other letters with the letter with maxFrequence. So we use the
  //length of slding window under this condition as possible max length
  //4. when the difference is out of K, we shrinking the window, and deduct the frequence in HashMap
  public static int findLength(String str, int k){
    HashMap<Character, Integer> map = new HashMap<>();
    int windowStart = 0;
    int maxLen = Integer.MIN_VALUE;
    int maxFrequence = Integer.MIN_VALUE;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char c = str.charAt(windowEnd);
      map.put(c, map.getOrDefault(c, 0) + 1);
      maxFrequence = Math.max(maxFrequence, map.get(c));

      if(windowEnd - windowStart + 1 - maxFrequence > k){
        char temp = str.charAt(windowStart);
        map.put(temp, map.get(temp) - 1);
        windowStart++;
      }

      int len = windowEnd - windowStart + 1;
      maxLen = Math.max(len, maxLen);
    }
    
    return maxLen;
  }
  public static void main(String[] args) {
    int res1 = CharacterReplacement.findLength("aabccbb", 2);
    System.out.println(res1);

    int res2 = CharacterReplacement.findLength("abbcb", 1);
    System.out.println(res2);

    int res3 = CharacterReplacement.findLength("abccde", 1);
    System.out.println(res3);
  }
}
