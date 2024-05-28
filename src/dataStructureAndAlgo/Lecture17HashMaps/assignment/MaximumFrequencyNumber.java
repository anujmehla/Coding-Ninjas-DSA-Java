package dataStructureAndAlgo.Lecture17HashMaps.assignment;

import java.util.HashMap;
import java.util.Map;

/*
Problem : Maximum Frequency Number
You are given an array of integers that contain numbers in random order. Write a program to find and return the number
 which occurs the maximum times in the given input.

If two or more elements are having the maximum frequency, return the element which occurs in the array first.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6
Sample Output 1 :
2
Sample Input 2 :
6
7 2 2 4 8 4
Sample Output 2 :
2
Explanation:
Here, both element '2' and element '4' have same frequency but '2' occur first in original array that's why we are
returning '2' as output.
 */
public class MaximumFrequencyNumber {
    public static void main(String[] args) {
        int[] arr = {7,2,2,4,8,4};
        System.out.println(maxFrequencyNumber(arr));
    }

    //tc (n)
    //sc O(n)
    //where n is the size of the input array
    public static int maxFrequencyNumber(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i : arr) {
            if (map.get(i) > maxValue) {
                maxValue = map.get(i);
                ans = i;
            }
        }
        return ans;
    }
}
