package dataStructuresAndAlgorithms.Lecture9LinkedList2.lecture;

import dataStructuresAndAlgorithms.Lecture9LinkedList2.util.Node;

import static dataStructuresAndAlgorithms.Lecture9LinkedList2.util.LinkedListUtilityClass.*;
/*
Question : Midpoint LinkedList
Problem statement
For a given singly linked list of integers, find and return the node present at the middle of the list.

Note :
If the length of the singly linked list is even, then return the first middle node.

Example: Consider, 10 -> 20 -> 30 -> 40 is the given list,
then the nodes present at the middle with respective data values are, 20 and 30. We return the first node with data 20.
Detailed explanation ( Input/output format, Notes, Images )
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run.
Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a
single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence,
would never be a list element
 Output Format :
For each test case/query, print the data value of the node at the middle of the given list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
3
Sample Input 2 :
2
-1
1 2 3 4 -1
Sample Output 2 :
2
 */

public class MidpointOfLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        int length = lengthOfLinkedList(head);
        System.out.println("Length of the linked list is "+length);
//        head = midpointOfLinkedList(head,length);
//        head = midpointOfLinkedList2(head);
        head = midpointOfLinkedList3(head);
        System.out.println("Midpoint of the linked list is "+head.data);
        print(head);
    }
    //using length
    public static Node<Integer> midpointOfLinkedList(Node<Integer> head,int length) {
        if (head == null || head.next == null) {
            return head;
        }
        int midpoint = length/2;
        while (midpoint > 0) {
            head = head.next;
            midpoint--;
        }
        return head;
    }
    //my solution
    //without using length
    public static Node<Integer> midpointOfLinkedList2(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null ) {
            if (fast.next.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //their solution
    public static Node<Integer> midpointOfLinkedList3(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}