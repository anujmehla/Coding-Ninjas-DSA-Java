package dataStructureAndAlgo.Lecture17HashMaps.assignment;

import java.util.HashMap;

/*
Problem : Pair Sum
Problem statement
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.



Note:
Array A can contain duplicate elements as well.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^4
Time Limit: 1 sec
Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2
Explanation
(2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2.
 */
public class PairSum {
    public static void main(String[] args) {
        int[] arr = {2,1,-2,2,3};
        int size = arr.length;
        System.out.println(PairSumFunction(arr, size));
    }

    //tc (n)
    //sc O(n) where n is the input array
    public static int PairSumFunction(int[] input, int size) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int finalCount = 0;
        for (int i = 0; i < size; i++) {
            int key = input[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key,1);
            }
        }
        //traversing the array and checking if the -key is present in hashmap
        for (int i = 0; i < size; i++) {
            int key = input[i];
            if (map.containsKey(key) && map.get(key) != 0) {
                int times;
                if (key == (-key)) {
                    int occurrences = map.get(key);
                    times = (occurrences * (occurrences -1 )/2);
                    finalCount = finalCount + times;
                    map.put(key,0);
                    continue;
                }
                times = map.get(key) * map.get(-key);
                finalCount = finalCount+times;
                map.put(key,0);
                map.put(-key,0);
            }
        }
        return finalCount;
    }
}
