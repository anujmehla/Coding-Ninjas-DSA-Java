package dataStructuresAndAlgorithms.Lecture8LinkedList1.lecture;

import java.util.Scanner;

/*
Question : Count of linked list
Problem statement
Given the head of a singly linked list of integers, find and return its length.


Example:
Sample Linked List

The length of the list is 4. Hence we return 4.

Note:
Exercise caution when dealing with edge cases, such as when the head is NULL.
Failing to handle these edge cases appropriately may result in a runtime error in your code.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 4 5 2 6 1 9 -1


Sample Output 1 :
7


Explanation of sample input 1 :
The number of nodes in the given linked list is 7.
Hence we return 7.


Sample Input 2 :
10 76 39 -3 2 9 -23 9 -1

Sample Output 2 :
8


Expected Time Complexity:
Try to do this in O(n).


 Constraints :
0 <= N <= 10^5
Time Limit: 1 sec
 */
public class LengthOfLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
        System.out.print("\n Length of the linked list is : "+length(head));
    }
    public static int length(Node<Integer> head) {
        int length = 0;
        Node<Integer> temp = head;
        while (temp!=null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public static Node<Integer> takeInput() {
        Scanner input = new Scanner(System.in);
        Node<Integer> head = null;
        Node<Integer> tail = null;
        int data = input.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = input.nextInt();
        }
        return head;
    }
    public static void print(Node<Integer> head) {
        while (head!= null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}