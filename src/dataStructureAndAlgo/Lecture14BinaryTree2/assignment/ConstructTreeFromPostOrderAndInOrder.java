package dataStructureAndAlgo.Lecture14BinaryTree2.assignment;

import dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeNode;

import static dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeUse.printTree;

/*
Problem : Construct Tree From Post Order And In Order
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1
4 2 5 1 6 3 7
Sample Output 1:
1
2 3
4 5 6 7
Sample Input 2:
6
2 9 3 6 10 5
2 6 3 9 5 10
Sample Output 2:
5
6 10
2 3
9
 */
public class ConstructTreeFromPostOrderAndInOrder {
    public static void main(String[] args) {
        int[] postOrder = {2,9,3,6,10,5};
        int[] inOrder = {2,6,3,9,5,10};
        BinaryTreeNode<Integer> root = buildTree(postOrder,inOrder);
        printTree(root);
    }
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        //Your code goes here
        int n = postOrder.length;
        int postStart = 0;
        int postEnd = n - 1;
        int inStart = 0;
        int inEnd = n-1;
        return buildTreeHelper(postOrder, postStart, postEnd, inOrder, inStart, inEnd);
    }

    private static BinaryTreeNode<Integer> buildTreeHelper(
            int[] postOrder,
            int postStart,
            int postEnd,
            int[] inOrder,
            int inStart,
            int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = postOrder[postEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootVal);
        int k = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (rootVal == inOrder[i]) {
                k = i;
                break;
            }
        }

        root.left = buildTreeHelper(postOrder,postStart,postStart+k-inStart-1,inOrder,inStart,k-1);
        root.right = buildTreeHelper(postOrder,postStart+k-inStart,postEnd-1,inOrder,k+1,inEnd);
        return root;
    }

}
