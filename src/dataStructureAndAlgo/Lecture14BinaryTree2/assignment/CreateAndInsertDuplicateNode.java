package dataStructureAndAlgo.Lecture14BinaryTree2.assignment;

import dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeNode;

import static dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeUse.printTree;
import static dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeUse.takeInputLevelWise;

/*
Problem : Create & Insert Duplicate Node
Problem statement
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.

The root will remain the same. So you just need to insert nodes in the given Binary Tree.

Example:
alt txt

After making the changes to the above-depicted tree, the updated tree will look like this.
alt txt

You can see that every node in the input tree has been duplicated and inserted to the left of itself.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
Sample Output 1:
10
10 30
20 30 60
20 50 60
40 50
40
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 2:
8
8 10
5 10
5 6
2 6 7
2 7
images are available for this question
 */
public class CreateAndInsertDuplicateNode {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree(root);
        insertDuplicateNode(root);
    }

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<>(root.data);
        BinaryTreeNode<Integer> originalLeft = root.left;
        root.left = duplicate;
        duplicate.left = originalLeft;
        insertDuplicateNode(originalLeft);
        insertDuplicateNode(root.right);
    }
}
