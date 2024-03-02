package dataStructureAndAlgo.Lecture8LinkedList1.assignment;

import java.util.ArrayList;

import static dataStructureAndAlgo.Lecture8LinkedList1.assignment.FindNode.print;
import static dataStructureAndAlgo.Lecture8LinkedList1.assignment.FindNode.takeInput;

/*
Question : Palindrome Linked List
Problem statement
You have been given a head to a singly linked list of integers.
Write a function check to whether the list given is a 'Palindrome' or not.

Detailed explanation ( Input/output format, Notes, Images )
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the given list is not a palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        System.out.println(isPalindrome1(head));
    }

    public static boolean isPalindrome1(Node<Integer> head) {
        Node<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (node != null) {
            arr.add(node.data);
            node = node.next;
        }
        int start = 0, end = arr.size() - 1;
        while (start < end) {
            if (arr.get(start) != arr.get(end)) {
                return false;
            } else {
                start = start + 1;
                end = end - 1;
            }
        }

        return true;
    }

    //    their solution
    public static boolean isPalindrome(Node<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }
        //find list center
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while (fast.next == null || fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<Integer> secondHead = slow.next;
        slow.next = null;
        secondHead = reverse(secondHead);

        //compare two subLists now
        Node<Integer> firstSubList = secondHead;
        Node<Integer> secondSubList = head;
        while (firstSubList != null) {
            if (firstSubList.data != secondSubList.data) {
                return false;
            }
            firstSubList = firstSubList.next;
            secondSubList = secondSubList.next;
        }
        //rejoin the two subLists to restore the input list to its original form
        firstSubList = head;
        secondSubList = reverse(secondHead);

        while (firstSubList.next != null) {
            firstSubList.next = secondSubList;
        }
        firstSubList.next = secondSubList;
        return true;
    }

    private static Node<Integer> reverse(Node<Integer> head) {
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
