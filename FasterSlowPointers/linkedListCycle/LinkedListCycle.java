// Problem Statement #
// Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.

class ListNode{
  int value;
  ListNode Next;

  public ListNode(int value){
    this.value = value;
  }
}


//Time: O(N), since the fast and slow will continue move N steps, so the time complexity is O(N)
//Soace: O(1)
public class LinkedListCycle {
  //1. we set two pointer, one is fast and one slow
  //2. if there is a loop in the list, the fast will always catch up the slow one in the loop
  //3. if there no loop in the list, the fast will enter the end of the list 
  
  public static boolean hasCycle(ListNode head){
    ListNode fast = head;
    ListNode slow = head;

    while(fast.Next != null && fast.Next.Next != null){
      fast = fast.Next.Next;  
      slow = slow.Next;
      if(fast == slow) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    ListNode ln = new ListNode(1);
    ln.Next = new ListNode(2);
    ln.Next.Next = new ListNode(3);
    ln.Next.Next.Next = new ListNode(4);
    ln.Next.Next.Next.Next = new ListNode(5);
    ln.Next.Next.Next.Next.Next = new ListNode(6);

    System.out.println(hasCycle(ln));

    ln.Next.Next.Next.Next.Next.Next = ln.Next.Next;
    System.out.println(hasCycle(ln));

    ln.Next.Next.Next.Next.Next.Next = ln.Next.Next.Next;
    System.out.println(hasCycle(ln));

  }
}
