package dataStructureAndAlgo.Lecture9LinkedList2.util;

import java.util.Scanner;

public class LinkedListUtilityClass {
    public static Node<Integer> takeInput() {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = scanner.nextInt();
        }
        return head;
    }
    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static int lengthOfLinkedList(Node<Integer> head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
