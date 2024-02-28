package dataStructureAndAlgo.Lecture13BinaryTree;

import dataStructureAndAlgo.Lecture11Queues.QueueUsingLL;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;

import java.util.Scanner;

public class BinaryTreeUse {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        BinaryTreeNode<Integer> root = takeInput(s);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree(root);
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//        root.left = node1;
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//        root.right = node2;


    }
    public static BinaryTreeNode<Integer> takeInput(Scanner s) {
        int rootData;
        System.out.println("Enter root data");
        rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner scanner = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        System.out.println("Enter root data");
        int rootData = scanner.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.println("Enter left child of " + front.data);
            int leftChild = scanner.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }
            System.out.println("Enter right child of " + front.data);
            int rightChild = scanner.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
        }
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String toBePrinted = root.data + "";
        if (root.left != null) {
            toBePrinted += "L:"+root.left.data+", ";
        }
        if (root.right != null) {
            toBePrinted += "R:"+root.right.data+", ";
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

}
