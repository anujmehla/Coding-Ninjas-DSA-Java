package dataStructureAndAlgo.Lecture9.lecture;

import dataStructureAndAlgo.Lecture9.util.Node;

import static dataStructureAndAlgo.Lecture9.util.LinkedListUtilityClass.takeInput;

public class PrintLLRecursively {
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head);
    }
    public static void print(Node<Integer> head) {
        if (head == null) {
            return;
        }
        print(head.next);
        System.out.print(head.data+" ");
    }
}
