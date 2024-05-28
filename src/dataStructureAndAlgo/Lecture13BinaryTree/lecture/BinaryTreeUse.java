package dataStructureAndAlgo.Lecture13BinaryTree.lecture;

import dataStructureAndAlgo.Lecture11Queues.QueueUsingLL;
import dataStructureAndAlgo.Lecture11Queues.exceptions.QueueEmptyException;
import dataStructureAndAlgo.Lecture13BinaryTree.lecture.BinaryTreeNode;
import dataStructureAndAlgo.Lecture14BinaryTree2.lecture.BalancedTreeReturn;
import dataStructureAndAlgo.Lecture14BinaryTree2.lecture.Pair;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        BinaryTreeNode<Integer> root = takeInput(s);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree(root);
        System.out.println("Number of Nodes in a binary tree : " + countNode(root));
        System.out.println("Is Node present in the tree : " + isNodePresent(root, 7));
        printLevelWise(root);
        System.out.println("Largest Number in the tree is : "+largest(root));
        System.out.println("Nodes greater than x are "+countNodesGreaterThanX(root,2));
        System.out.println("Height of the tree is "+height(root));
        System.out.println("Number of leaves of tree are "+numOfLeaves(root));
        System.out.println("Print at depth k");
        printAtDepthK(root,2);
        BinaryTreeNode<Integer> newRoot = removeLeaves(root);
//        System.out.println("New Tree");
//        printTree(newRoot);

//        System.out.println("Is Balanced : "+isBalanced(root));
        System.out.println("Is Balanced : "+isBalancedBetter(root).isBalanced);

        System.out.println("Diameter is : "+diameter(root));

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
        String toBePrinted = root.data + ": ";
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

    public static int countNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        ans+= countNode(root.left);
        ans+= countNode(root.right);
        return ans;
    }
    //my solution
    public static int getSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        sum += getSum(root.left);
        sum += getSum(root.right);
        return sum;
    }
    //their solution
    public static int getSum2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum2(root.left);
        int rightSum = getSum2(root.right);

        return (leftSum + rightSum + root.data);
    }
    // my solution
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        boolean isPresent = false;
        if (root.data == x) {
            return true;
        }
        isPresent = isNodePresent(root.left,x);
        if (isPresent == true) {
            return isPresent;
        }
        isPresent = isNodePresent(root.right,x);
        if (isPresent == true) {
            return isPresent;
        }
        return isPresent;
    }
    /*
    time complexity : O(n)
    space complexity : O(h)
     where n is the number of nodes in the tree
     and h is the height of the tree.

     h is equal to log(n) for a balanced tree
     */
    //their solution
    public static boolean isNodePresent2(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data.equals(x)) {
            return true;
        }
        return (isNodePresent2(root.left, x) || isNodePresent2(root.right, x));
    }
    //my solution
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = null;
            try {
                frontNode = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                //it won't come to this
            }
            if (frontNode != null && frontNode.left != null && frontNode.right != null) {
                System.out.println(frontNode.data+":L:"+ frontNode.left.data+",R:"+frontNode.right.data);
                pendingNodes.enqueue(frontNode.left);
                pendingNodes.enqueue(frontNode.right);
            } else if (frontNode != null && frontNode.left != null) {
                System.out.println(frontNode.data + ":L:" + frontNode.left.data + ",R:" + "-1");
                pendingNodes.enqueue(frontNode.left);
            } else {
                if (frontNode != null && frontNode.right != null) {
                    System.out.println(frontNode.data + ":L:" + "-1" + ",R:" + frontNode.right.data);
                    pendingNodes.enqueue(frontNode.right);
                } else {
                    System.out.println(frontNode.data + ":L:-1,R:-1");
                }
            }
        }
    }
    //their solution
    public static void printLevelWise2(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
            if (frontNode == null) {
                System.out.println();
                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }
            } else {
                System.out.print(frontNode.data+":L:");
                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                    System.out.print(frontNode.left.data + ",R:");
                } else {
                    System.out.print(-1+",R:");
                }
                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                    System.out.println(frontNode.right.data);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }
    //my solution
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data > x) {
            count++;
        }
        count += countNodesGreaterThanX(root.left,x);
        count += countNodesGreaterThanX(root.right,x);
        return count;
    }
    //their solution
    public static int countNodesGreaterThanX2(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        int count = (root.data > x) ? 1 : 0;
        if (root.left != null) {
            count += countNodesGreaterThanX2(root.left, x);
        }
        if (root.right != null) {
            count += countNodesGreaterThanX2(root.right, x);
        }
        return count;
    }
    //chat gpt
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    /*
    time complexity is O(n)
    space complexity is O(h)
    where n is number of nodes in the input tree and
    h is the height of the input tree
     */
    //their solution
    public static int height2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height2(root.left), height2(root.right))+1;
    }

    public static int numOfLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }
        return numOfLeaves(root.left) + numOfLeaves(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        printAtDepthK(root.left,k-1);
        printAtDepthK(root.right,k-1);
    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

    //time complexity is O(n(height))
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        //this for checking each and every node
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isRightBalanced && isLeftBalanced;
    }
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            int height = 0;
            boolean isBalanced = true;
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = height;
            ans.isBalanced = isBalanced;
            return ans;
        }
        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);
        boolean isBal = true;
        int height = Math.max(leftOutput.height, rightOutput.height)+1;

        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isBal = false;
        }

        if (!leftOutput.isBalanced || !rightOutput.isBalanced) {
            isBal = false;
        }

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }
    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int option1 = height(root.left)+height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1, Math.max(option2,option3));
    }
    //tc : O(n)
    public Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer,Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        Pair<Integer,Integer> leftOutput = heightDiameter(root.left);
        Pair<Integer,Integer> rightOutput = heightDiameter(root.right);
        int height = 1 + Math.max(leftOutput.first,rightOutput.first);
        int option1 = leftOutput.first + rightOutput.first;
        int option2 = leftOutput.second;
        int option3 = rightOutput.second;
        int diameter = Math.max(option1,Math.max(option2,option3));
        Pair<Integer,Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;
    }

    private static Pair2 diameterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair2 pair = new Pair2(0, 0);
            return pair;
        }
        Pair2 leftPair = diameterHelper(root.left);
        Pair2 rightPair = diameterHelper(root.right);

        int leftDiameter = leftPair.diameter;
        int rightDiameter = rightPair.diameter;

        int dist = leftPair.height + rightPair.height + 1;
        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
        int height = Math.max(leftPair.height, rightPair.height) + 1;

        return (new Pair2(diameter, height));
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        Pair2 pair2 = diameterHelper(root);
        return pair2.diameter;
    }
}
class Pair2{
    int diameter;
    int height;

    public Pair2(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}
