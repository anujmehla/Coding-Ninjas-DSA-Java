package dataStructureAndAlgo.Lecture10Stacks;

import java.util.Stack;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
//        StackUsingArray stack = new StackUsingArray();
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            try {
                System.out.println(stack.pop());
            } catch (StackEmptyException e) {
                //never reach here
            }
        }
    }
}
