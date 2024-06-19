package dataStructuresAndAlgorithms.Lecture14BinaryTree2.lecture.Exercise;

import dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

import static dataStructuresAndAlgorithms.Lecture13BinaryTree.lecture.BinaryTreeUse.*;

/*
Problem statement
For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^3
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7
4 2 5 1 6 3 7
Sample Output 1:
1
2 3
4 5 6 7
Sample Input 2:
6
5 6 2 3 9 10
2 6 3 9 5 10
Sample Output 2:
5
6 10
2 3
9
 */
public class ConstructTreeFromPreOrderAndInOrder {
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] inOrder = {4,2,5,1,6,3,7};
        BinaryTreeNode<Integer> root = buildTree2(preOrder,inOrder);
        printTree(root);
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        // Map to store the index of each element in inorder array for quick access
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inorderIndexMap.put(inOrder[i], i);
        }
        // Start the recursive construction of the tree
        return buildTreeRecursive(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inorderIndexMap);
    }
    private static BinaryTreeNode<Integer> buildTreeRecursive(int[] preOrder, int preStart, int preEnd,
                                                              int[] inOrder, int inStart, int inEnd,
                                                              Map<Integer, Integer> inorderIndexMap) {
        // Base case: if the subtree has no elements
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootValue = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootValue);

        // Get the index of the root in inorder array
        int inRootIndex = inorderIndexMap.get(rootValue);
        int leftSubtreeSize = inRootIndex - inStart;

        // Recursively construct the left subtree
        root.left = buildTreeRecursive(preOrder, preStart + 1, preStart + leftSubtreeSize,
                inOrder, inStart, inRootIndex - 1, inorderIndexMap);

        // Recursively construct the right subtree
        root.right = buildTreeRecursive(preOrder, preStart + leftSubtreeSize + 1, preEnd,
                inOrder, inRootIndex + 1, inEnd, inorderIndexMap);

        return root;
    }

    //their solution
    private static BinaryTreeNode<Integer> buildTreeHelper(
            int[] preOrder,
            int preStart,
            int preEnd,
            int[] inOrder,
            int inStart,
            int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootVal);
        int k = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (rootVal == inOrder[i]) {
                k = i;
                break;
            }
        }
        root.left = buildTreeHelper(preOrder,preStart+1,preStart+(k-inStart),inOrder,inStart, k-1);
        root.right = buildTreeHelper(preOrder,preStart+(k-inStart)+1,preEnd,inOrder,k+1,inEnd);
        return root;
    }
    public static BinaryTreeNode<Integer> buildTree2(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        int preStart = 0;
        int preEnd = n -1;
        int inStart = 0;
        int inEnd = n - 1;

        return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
    }
}
