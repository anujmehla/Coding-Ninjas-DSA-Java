package dataStructuresAndAlgorithms.Lecture17HashMaps.lecture;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,5,5,5};
        ArrayList<Integer> ans = removeDuplicates(arr);
        print(ans);
    }

    //the main thing about this function is tc i.e., O(n)
    public static ArrayList<Integer> removeDuplicates(int[] a) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for (int j : a) {
            if (seen.containsKey(j)) { //O(1)
                continue;
            }
            output.add(j);
            seen.put(j, true); //O(1)
        }
        return output;
    }

    private static void print(ArrayList<Integer> arrayList) {
        for (int i : arrayList) {
            System.out.print(i+" ");
        }
    }
}
