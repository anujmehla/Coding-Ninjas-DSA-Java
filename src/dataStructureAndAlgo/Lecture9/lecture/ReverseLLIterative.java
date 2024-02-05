package dataStructureAndAlgo.Lecture9.lecture;

import dataStructureAndAlgo.Lecture9.util.Node;

import static dataStructureAndAlgo.Lecture9.util.LinkedListUtilityClass.print;
import static dataStructureAndAlgo.Lecture9.util.LinkedListUtilityClass.takeInput;

/*
Question : Reverse Linked List (Iterative)
Problem statement
Given a singly linked list of integers, reverse it iteratively and return the head to the modified list.

 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
Sample Output 1 :
8 7 6 5 4 3 2 1
Sample Input 2 :
2
10 -1
10 20 30 40 50 -1
Sample Output 2 :
10
50 40 30 20 10
 */
public class ReverseLLIterative {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = reverse(head);
        print(head);
    }
    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> previous = null;
        Node<Integer> forward = null;
        while (current != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }
        return previous;
    }
}
