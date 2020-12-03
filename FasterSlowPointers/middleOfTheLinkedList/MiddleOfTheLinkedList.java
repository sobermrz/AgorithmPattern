// Problem Statement #
// Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

// If the total number of nodes in the LinkedList is even, return the second middle node.

//Time: O(N)
//Space: O(1)
class ListNode{
  int value;
  ListNode next;

  public ListNode(int value){
    this.value = value;
  }
}

public class MiddleOfTheLinkedList {
  public static int findMiddle(ListNode node){
    ListNode dummy = new ListNode(0);
    dummy.next = node;

    ListNode slow = dummy;
    ListNode fast = dummy;

    while(fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow.next.value;
  }
  public static void main(String[] args) {
    ListNode ln = new ListNode(1);
    ln.next = new ListNode(2);
    ln.next.next = new ListNode(3);
    ln.next.next.next = new ListNode(4);
    ln.next.next.next.next = new ListNode(5);
    System.out.println(findMiddle(ln));

    ln.next.next.next.next.next = new ListNode(6);
    System.out.println(findMiddle(ln));

    ln.next.next.next.next.next.next = new ListNode(7);
    System.out.println(findMiddle(ln));
  }
}
