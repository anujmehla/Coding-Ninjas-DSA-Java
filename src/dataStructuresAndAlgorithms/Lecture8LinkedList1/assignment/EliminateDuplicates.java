package dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment;

import static dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment.FindNode.print;
import static dataStructuresAndAlgorithms.Lecture8LinkedList1.assignment.FindNode.takeInput;

/*
Question : Eliminate Duplicates
Problem statement
You have been given a singly linked list of integers where the elements are sorted in ascending order.
Write a function that removes the consecutive duplicate values such that the given list only contains unique elements
and returns the head to the updated list.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence,
would never be a list element.
Sample Input 1 :
1
1 2 3 3 3 3 4 4 4 5 5 7 -1
Sample Output 1 :
1 2 3 4 5 7
Sample Input 2 :
2
10 20 30 40 50 -1
10 10 10 10 -1
Sample Output 2 :
10 20 30 40 50
10
 */
public class EliminateDuplicates {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        head = removeDuplicates(head);
        System.out.println("\nAfter removing the duplicate data : ");
        print(head);
    }
    //my solution
    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null && temp.next !=null) {
            if (temp.data.equals(temp.next.data)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
    //their solution
    public static Node<Integer> removeDuplicates1(Node<Integer> head) {
        if (head == null) {
            return head;
        }
        Node<Integer> currentHead = head;
        while (currentHead.next != null) {
            if (currentHead.data.equals(currentHead.next.data)) {
                currentHead.next = currentHead.next.next;
            } else {
                currentHead = currentHead.next;
            }
        }
        return head;
    }
}
