package dataStructuresAndAlgorithms.Lecture14BinaryTree2.lecture.Exercise;

import dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem : Mirror Binary Tree
Problem statement
For a given Binary Tree of type integer, update it with its corresponding mirror image.

Example:
Alt text

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1
3 2
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5
6 10
3 2
9

image also available for this question
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {

    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }

        // Swap the left and right children
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recur for the left and right subtrees
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }

    // Utility function to print the tree level-wise for verification
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    //their solution
    public static void mirrorBinaryTree2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        mirrorBinaryTree2(root.left);
        mirrorBinaryTree2(root.right);

        BinaryTreeNode<Integer> tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;
    }
}
