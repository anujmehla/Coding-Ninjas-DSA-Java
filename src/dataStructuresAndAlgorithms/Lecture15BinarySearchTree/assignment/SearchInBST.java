package dataStructuresAndAlgorithms.Lecture15BinarySearchTree.assignment;

import dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeNode;

import static dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeUse.*;

/*
Problem : Search in BST
Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.

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
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree(root);
        int k = 2;
        System.out.println(searchInBST(root, k));
    }

    //tc O(h)
    //sp O(h)
    //where h is the height of the input BST
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return false;
        if (root.data == k) {
            return true;
        } else if (root.data > k) {
            return searchInBST(root.left, k);
        } else {
            return searchInBST(root.right, k);
        }
    }
}
