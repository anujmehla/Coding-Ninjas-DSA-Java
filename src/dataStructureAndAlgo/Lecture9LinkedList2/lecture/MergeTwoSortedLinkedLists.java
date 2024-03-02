package dataStructureAndAlgo.Lecture9LinkedList2.lecture;

import dataStructureAndAlgo.Lecture9LinkedList2.util.Node;

import static dataStructureAndAlgo.Lecture9LinkedList2.util.LinkedListUtilityClass.print;
import static dataStructureAndAlgo.Lecture9LinkedList2.util.LinkedListUtilityClass.takeInput;

/*
Question : Merge Two Sorted Linked Lists
Problem statement
You have been given two sorted(in ascending order) singly linked lists of integers.

Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order)
and return the new head to the list.

Note :
Try solving this in O(1) auxiliary space.

No need to print the list, it has already been taken care.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists.

Time Limit: 1sec
Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12
Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2 :
2 3 5 6 8 9 12
10 10 20 30 40 40 50 60 60 60 80 90 100
 */
public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        System.out.println("Enter the data for the first list :");
        Node<Integer> head1 = takeInput();
        print(head1);
        System.out.println("Enter the data for the second list :");
        Node<Integer> head2 = takeInput();
        print(head2);
        System.out.println("Method called ");
        Node<Integer> mergedAndSortedList = mergeTwoSorted(head1, head2);
        print(mergedAndSortedList);
    }

    //my solution
    public static Node<Integer> mergeTwoSorted(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node<Integer> result = null;
        Node<Integer> current;

        if (head1.data < head2.data) {
            result = head1;
            head1 = head1.next;
        } else {
            result = head2;
            head2 = head2.next;
        }
        current = result;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        //remaining elements
        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return result;
    }

    //their solution
    public static Node<Integer> mergeTwoSorted2(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node<Integer> newHead = null;
        Node<Integer> newTail = null;
        if (head1.data < head2.data) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            newTail.next = head1;
        }
        if (head2 != null) {
            newTail.next = head2;
        }
        return newHead;
    }
}
