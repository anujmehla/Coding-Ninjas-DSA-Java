package dataStructureAndAlgo.Lecture7OOPS.assignment;

import java.util.*;

/*
Question : Array Intersection
Problem statement
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively.
You need to print their intersection;
An intersection for this problem can be defined when both the arrays/lists contain a particular
 value or to put it in other words, when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in ascending order.


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= M <= 10^4

Time Limit: 1 sec
Sample Input 1 :
2
6
2 6 8 5 4 3
4
2 3 4 7
2
10 10
1
10
Sample Output 1 :
2 3 4
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 2 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, the intersection of the arrays also have two '2's.
The first '2' of first array matches with the first '2' of the second array. Similarly,
the second '2' of the first array matches with the second '2' if the second array.
 */
public class ArrayInteraction {
    public static void main(String[] args) {
        int[] arr1 = {2,6,1,2};
        int[] arr2 = {1,2,3,4,2};
        intersection(arr1,arr2);
    }
    /*
    Time complexity = O(mlogm) +O(nlogn) + O(m+n)
    Space complexity =
     */
    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}

//this logic failed as duplicates elements are allowed but set doesn't allow it
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> intersection = new HashSet<>();
//        for (int i : arr1) {
//            set.add(i);
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            if (set.contains(arr2[i])) {
//                intersection.add(arr2[i]);
//            }
//        }
//        Iterator<Integer> iterable =intersection.iterator();
//        while (iterable.hasNext()) {
//            System.out.println(iterable.next());
//        }