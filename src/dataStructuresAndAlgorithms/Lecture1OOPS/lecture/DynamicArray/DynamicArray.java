package dataStructuresAndAlgorithms.Lecture1OOPS.lecture.DynamicArray;

public class DynamicArray {
    private int[] data;
    private int nextIndex;

    DynamicArray() {
        data = new int[5];
        nextIndex = 0;
    }
    // add value to the end of array
    public void add(int value) {
        if (nextIndex == data.length) {
            restructure();
        }
        data[nextIndex] = value;
        nextIndex++;
    }
    public int size() {
        return nextIndex;
    }
    //to update the existing value of the array
    public void set(int index, int element) {
        if (index > nextIndex) {
            return;
        }
        if (index < nextIndex) {
            data[index] = element;
        } else {
            add(element);
        }
    }

    public int get(int index) {
        if (index >= nextIndex) {
            // error out
            return -1;
        }
        return data[index];
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int removeLast() {
        if (size() == 0) {
            // error out
            return -1;
        }
        int value = data[nextIndex-1];
        data[nextIndex-1] = 0;
        nextIndex--;
        return value;
    }
    private void restructure() {
        int[] newArray = new int[2* data.length];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }
}
