package dataStructureAndAlgo.Lecture9.lecture;

import dataStructureAndAlgo.Lecture9.util.Node;

import static dataStructureAndAlgo.Lecture9.util.LinkedListUtilityClass.print;
import static dataStructureAndAlgo.Lecture9.util.LinkedListUtilityClass.takeInput;

/*
Question : Reverse LL (Recursive)
Problem statement
Given a singly linked list of integers, reverse it using recursion and return the head to the modified list.
You have to do this in O(N) time complexity where N is the size of the linked list.

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
public class ReverseLL {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
//        head = reverseRec(head);
//        DoubleNode dn = reverse(head);
//        print(dn.head);
        head = reverse2(head);
        print(head);
    }
    public static Node<Integer> reverseRec1(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> finalHead = reverseRec1(head.next);
        Node<Integer> temp = finalHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return finalHead;
    }
    //their solution, time complexity is O(n^2)
    public static Node<Integer> reverseRec(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> smallHead = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return smallHead;
    }
    //another approach with O(n)
    public static DoubleNode reverse(Node<Integer> head) {
        if (head == null || head.next == null) {
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        DoubleNode smallAns = reverse(head.next);
        smallAns.tail.next = head;
        head.next = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }

    //another better approach, time complexity is O(n)
    public static Node<Integer> reverse2(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> reverseTail = head.next;
        Node<Integer> smallAns = reverse2(head.next);
        reverseTail.next = head;
        head.next = null;
        return smallAns;
    }
}
