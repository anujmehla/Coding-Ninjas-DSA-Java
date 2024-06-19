package dataStructuresAndAlgorithms.Lecture12Trees.assignment;

import dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeNode;

import java.util.Objects;

import static dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeUse.print;
import static dataStructuresAndAlgorithms.Lecture12Trees.lecture.TreeUse.takeInputLevelWise;

/*
Problem : Structurally Identical
Problem statement
Given two Generic trees, return true if they are structurally identical i.e.
they are made of nodes with the same values arranged in the same way.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Explanation
If we draw the tree for the above inputs, both the trees will look like this. So the answer for this is true.


Sample Input 2 :
10 3 20 30 40 2 40 50 0 0 0 0
10 3 2 30 40 2 40 50 0 0 0 0
Sample Output 2:
false
 */
public class StructurallyIdentical {
    public static void main(String[] args) {
        TreeNode<Integer> root1 = takeInputLevelWise();
        System.out.println("Now enter data for tree 2");
        TreeNode<Integer> root2 = takeInputLevelWise();
        print(root1);
        System.out.println("**********************");
        print(root2);
        System.out.println(checkIdentical(root1, root2));
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (!Objects.equals(root1.data, root2.data)) {
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }
        return true;
    }
}
