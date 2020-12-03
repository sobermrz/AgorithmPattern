// Problem Statement #
// Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

// Example 1:

// Input: 23   
// Output: true (23 is a happy number)  

// Example 2:

// Input: 12   
// Output: false (12 is not a happy number)  

//Time: LogN
//Space: O(1)
public class HappyNumber {
  //1. use two pointer.If happy number, both fast and slow will be ended up at 1
  //2. If not a happy number, they will meet at a number, since there is cycle
  public static boolean find(int num){
    int slow = num;
    int fast = num;

    do{
      //for the slow one, only calculate one step; for the fast one, calculate two steps
      slow = calSquare(slow);
      fast = calSquare(calSquare(fast));
    }while(slow != fast);

    return slow == 1;
    
  }

  public static int calSquare(int number){
    int res = 0;

    while(number > 0){
      int digit = number % 10;
      number /= 10;
      res += digit * digit;
    }

    return res;
  }

  public static void main(String[] args) {
    System.out.println(find(23));
    System.out.println(find(12));
  }
}
