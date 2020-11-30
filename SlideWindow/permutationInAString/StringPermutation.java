import java.util.HashMap;

// Given a string and a pattern, find out if the string contains any permutation of the pattern.

// Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

// abc
// acb
// bac
// bca
// cab
// cba
// If a string has ‘n’ distinct characters it will have 
// n
// !
// n! permutations.

// Example 1:

// Input: String="oidbcaf", Pattern="abc"
// Output: true
// Explanation: The string contains "bca" which is a permutation of the given pattern.
// Example 2:

// Input: String="odicf", Pattern="dc"
// Output: false
// Explanation: No permutation of the pattern is present in the given string as a substring.
// Example 3:

// Input: String="bcdxabcdy", Pattern="bcdyabcdx"
// Output: true
// Explanation: Both the string and the pattern are a permutation of each other.
// Example 4:

// Input: String="aaacb", Pattern="abc"
// Output: true
// Explanation: The string contains "acb" which is a permutation of the given pattern.

public class StringPermutation {
  //1. use HashMap to store character and its frequences of the pattern string
  //2. add character from string into sliding window: move windowEnd and until character
  //exists in HashMap, windowStart starts from windowEnd. Deduct frequences of the character
  //in HashMap.
  //3. if windowEnd come to a character that does not exists in the pattern, shrink the sliding window
  //from windowStart, and return the frequence of the removed character, until windowEnd meets to the windowEnd
  //4. Repeat Step 2, 3, 4 until size of HashMap equals to 0, then return true. Or return false

  public static boolean findPermutation(String str, String pattern){
    HashMap<Character, Integer> map = new HashMap<>();
    //use hashmap to store pattern
    for(int i = 0; i < pattern.length(); i++){
      char c = pattern.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int size = map.size();

    int flag = 1;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char temp = str.charAt(windowEnd);
      if(map.containsKey(temp)){
        //windowStart will be record when the first character matches, only record one time
        if(flag == 1){
          windowStart = windowEnd;
          flag--;
        }
        //put temp into the sliding window, dudect the its frequence in HashMap
        map.put(temp, map.get(temp) - 1);
        if(map.get(temp) == 0){
          map.remove(temp);
        }
      } else if(!map.containsKey(temp) && map.size() != size){
        //only enter when map does not contain the key, and before, so pattern was matched!!!

        //does not exist in HashMap, now shrink the sliding window
        //and return the frequences to the Hashmap until windowStart == window

        //release the flag
        flag = 1;
        //shrinking the sliding window
        while(windowStart < windowEnd){
          char s = str.charAt(windowStart);
          map.put(s, map.getOrDefault(s, 0) + 1);
          windowStart++;
        }
      }

      //if size of map equals to 0, there is permutation in the str
      if(map.size() == 0) return true;
    }

    return false;
  }
  public static void main(String[] args) {
    boolean res1 = findPermutation("oidbcaf", "abc");
    System.out.println(res1);

    boolean res2 = findPermutation("odicf", "dc");
    System.out.println(res2);

    boolean res3 = findPermutation("bcdxabcdy", "bcdyabcdx");
    System.out.println(res3);

    boolean res4 = findPermutation("aaacb", "abc");
    System.out.println(res4);

    boolean res5 = findPermutation("abdabc", "abc");
    System.out.println(res5);
  }
}
