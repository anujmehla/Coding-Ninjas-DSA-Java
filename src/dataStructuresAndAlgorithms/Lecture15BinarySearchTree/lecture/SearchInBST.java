package dataStructuresAndAlgorithms.Lecture15BinarySearchTree.lecture;

import dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeNode;

import static dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeUse.printTree;
import static dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeUse.takeInputLevelWise;

/*
Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true,
if node with data k is present, return false otherwise.

Note:
Assume that BST contains all unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
false
 */
public class SearchInBST {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise(); //8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        System.out.println("Issue here");
        printTree(root);
        System.out.println(searchInBST(root, 9));
    }

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        if (root.data > value) {
            return searchInBST(root.left, value);
        } else {
            return searchInBST(root.right, value);
        }
    }
}
