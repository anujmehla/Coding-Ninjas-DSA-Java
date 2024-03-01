package dataStructureAndAlgo.Lecture13BinaryTree.assignment;

import dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeNode;
import dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeUse;

import static dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeUse.takeInputLevelWise;

/*
Problem - Is Node Present
Problem statement
For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5

Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec.
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
7
Sample Output 1:
true
Explanation For Output 1:
Clearly, we can see that 7 is present in the tree. So, the output will be true.
Sample Input 2:
2 3 4 -1 -1 -1 -1
10
Sample Output 2:
false
 */
public class IsNodePresent {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println("Is the given node present " + isNodePresent(root, 7));
    }
    // my solution
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        boolean ans = root.data.equals(x);
        if (ans) return true;
        boolean leftAnswer = isNodePresent(root.left,x);
        boolean rightAnswer = isNodePresent(root.right,x);
        if (leftAnswer || rightAnswer) {
            return true;
        }
        return ans;
    }
    //their solution
    public static boolean isNodePresent2(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data.equals(x)) {
            return true;
        }
        return (isNodePresent2(root.left,x) || BinaryTreeUse.isNodePresent2(root.right,x));
    }
}
