package dataStructuresAndAlgorithms.Lecture15BinarySearchTree.lecture;

import dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeNode;

import static dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeUse.*;

/*
Given a Binary Search Tree and two integers k1 and k2,
find and print the elements which are in range k1 and k2 (both inclusive).

Print the elements in increasing order.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10
 */
public class ElementsBetweenK1andK2 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();//8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        printTree(root);
        elementsBetweenK1andK2(root,6,10);
    }
    public static void elementsBetweenK1andK2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data > k1 ) {
            elementsBetweenK1andK2(root.left, k1, k2);
        } else if (root.data >= k1 && root.data < k2) {
            System.out.println(root.data + " ");
        }
        if (root.data < k2) {
            elementsBetweenK1andK2(root.right,k1,k2);
        }

    }
}
