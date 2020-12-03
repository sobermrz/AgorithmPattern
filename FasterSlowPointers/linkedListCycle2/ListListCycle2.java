// Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.

class ListNode{
  int value;
  ListNode next;

  public ListNode(int value){
    this.value = value;
  }
}
public class ListListCycle2 {
  //1. use fast and slow pointer to get the meet up point
  //2. use another pointer, starting from the meetup point, count how many 
  //steps it need to meet slow again
  public static int findCycleLength(ListNode head){
    ListNode fast = head;
    ListNode slow = head;

    int len = 0;

    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;

      if(fast == slow){
        len = calLen(slow);
        break;
      }
    }
    return len;
  }

  public static int calLen(ListNode slow){
    ListNode temp = slow;
    int cnt = 0;
    while(temp.next != slow){
      cnt++;
      temp = temp.next;
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

    System.out.println("==============");
    ln.next.next.next.next.next.next = ln.next.next;
    System.out.println(findCycleLength(ln));

    System.out.println("==============");
    ln.next.next.next.next.next.next = ln.next.next.next;
    System.out.println(findCycleLength(ln));
  }
}
