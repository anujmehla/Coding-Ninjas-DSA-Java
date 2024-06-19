package dataStructuresAndAlgorithms.Lecture9LinkedList2.assignment;

import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.print;
import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.takeInput;

/*
Question : Bubble Sort (Iterative) Linked List
Problem statement
Given a singly linked list of integers, sort it using 'Bubble Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10^3
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10
 Sample Input 2 :
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90
 */
public class BubbleSortLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        print(bubbleSort(head));
    }

    private static int length(Node<Integer> head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    /*
    Time Complexity : O(n^2)
    Space Complexity : O(1)
    Where 'n' is size of the Singly Linked List
    */
    public static Node<Integer> bubbleSort(Node<Integer> head) {
        int n = length(head);

        for (int i = 0; i < (n - 1); i++) {
            Node<Integer> previous = null;
            Node<Integer> current = head;

            for (int j = 0; j < (n-i-1); j++) {
                if (current.data <= current.next.data) {
                    previous = current;
                    current = current.next;
                } else {
                    if (previous == null) {
                        Node<Integer> forward = current.next;
                        head = head.next;
                        current.next = forward.next;
                        forward.next = current;
                        previous = forward;
                    } else {
                        Node<Integer> forward = current.next;
                        previous.next = forward;
                        current.next = forward.next;
                        forward.next = current;
                        previous = forward;
                    }
                }
            }
        }
        return head;
    }
}
