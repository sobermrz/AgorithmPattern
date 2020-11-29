import java.util.HashMap;

// Problem Statement #
// Given a string, find the length of the longest substring which has no repeating characters.

// Example 1:

// Input: String="aabccbb"
// Output: 3
// Explanation: The longest substring without any repeating characters is "abc".
// Example 2:

// Input: String="abbbb"
// Output: 2
// Explanation: The longest substring without any repeating characters is "ab".
// Example 3:

// Input: String="abccde"
// Output: 3
// Explanation: Longest substrings without any repeating characters are "abc" & "cde".


public class NoRepeatSubstring {
  //1. use sliding window to add character into window, until duplicate
  //character occurs. meanwhile, use hashmap to store the adding character
  //and its frequence
  //2. calculate the length of window and update the max length
  //3. remove the element until no duplicate element occurs in the window
  //4. repeat steps above
  public static int findLength(String s){
    HashMap<Character, Integer> map = new HashMap<>();
    int maxLen = Integer.MIN_VALUE;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
      char c = s.charAt(windowEnd);
      map.put(c, map.getOrDefault(c, 0) + 1);

      int len = windowEnd - windowStart + 1;

      //check the dulipcate
      if(map.get(c) > 1){
        //calculate the len
        len--;
        //loop to remove element from the start position of the window
        while(map.get(c) > 1){
          char temp = s.charAt(windowStart);
          map.put(temp, map.get(temp) - 1);

          if(map.get(temp) == 0){
            map.remove(temp);
          }

          windowStart++;
        }
      }
      maxLen = Math.max(len, maxLen);

    }
    return maxLen;
  }

  public static void main(String[] args) {
    int res1 = NoRepeatSubstring.findLength("aabcc");
    System.out.println(res1);
    int res2 = NoRepeatSubstring.findLength("abbbb");
    System.out.println(res2);
    int res3 = NoRepeatSubstring.findLength("abccde");
    System.out.println(res3);
    int res4 = NoRepeatSubstring.findLength("abcdefg");
    System.out.println(res4);
  }
  
}
