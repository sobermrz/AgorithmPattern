// Problem Statement #
// Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
class ListNode{
  int value = 0;
  ListNode next;

  public ListNode(int value){
    this.value = value;
  }
}

//Time: O(N). Finding the cycle in the list requires N, calculate the length of cycle
//requires N, and find the start of the cycle requires N too. Thus, the time complexisty is O(N)
//Space: O(1)

class LinkedListCyleStart {
  //1. calculate the length of the cycle, assuming n
  //2. use two pointer, the fast pointer move n steps. Then move
  //fast and slow pointer together until they meet
  public static int findCycleStart(ListNode head){
    ListNode fast = head;
    ListNode slow = head;
    int len = 0;


    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
      
      //calculate the length of cycle
      if(fast == slow){
        len = calLen(slow);
        break;
      }
    }

    fast = head;
    slow = head;

    //move fast pointer n(n equals to len of cycle) steps ahead
    for(int i = 0; i < len; i++){
      fast = fast.next;
    }

    while(fast != slow){
      fast = fast.next;
      slow = slow.next;
    }

    return slow.value;

  }

  public static int calLen(ListNode slow) {
    ListNode temp = slow;
    int cnt = 0;

    while(temp.next != slow){
      temp = temp.next;
      cnt++;
    }

    return cnt + 1;
  }

  public static void main(String[] args) {
    ListNode ln = new ListNode(1);
    ln.next = new ListNode(2);
    ln.next.next = new ListNode(3);
    ln.next.next.next = new ListNode(4);
    ln.next.next.next.next = new ListNode(5);
    ln.next.next.next.next.next = new ListNode(6);

    ln.next.next.next.next.next.next = ln.next.next;
    System.out.println(findCycleStart(ln));

    ln.next.next.next.next.next.next = ln.next.next.next;
    System.out.println(findCycleStart(ln));

    ln.next.next.next.next.next.next = ln;
    System.out.println(findCycleStart(ln));
  }
}
