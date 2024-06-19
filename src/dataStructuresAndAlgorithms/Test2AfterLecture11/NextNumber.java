package dataStructuresAndAlgorithms.Test2AfterLecture11;

/*
Problem : Next number
Given a large number represented in the form of a linked list.
Write code to increment the number by 1 in-place(i.e. without using extra space).

Note: You don't need to print the elements, just update the elements and return the head of updated LL. Input Constraints:
1 <= Length of Linked List <=10^6.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0
 */
public class NextNumber {
    public static void main(String[] args) {


    }
    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        if (head == null) {
            return null;
        }

        // Step 1: Reverse the linked list
        head = reverseList(head);

        // Step 2: Add one to the number
        LinkedListNode<Integer> current = head;
        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            if (current.next == null && carry > 0) {
                current.next = new LinkedListNode<>(carry);
                carry = 0;
            }
            current = current.next;
        }

        // Step 3: Reverse the list again to restore the original order
        head = reverseList(head);

        return head;
    }
    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }


}
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}