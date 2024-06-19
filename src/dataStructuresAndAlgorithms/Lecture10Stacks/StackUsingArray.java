package dataStructuresAndAlgorithms.Lecture10Stacks;

public class StackUsingArray {
    private int data[];
    private int top; //is the index topmost element of stack
    public StackUsingArray() {
        data = new int[10];
        top = -1;
    }

    public StackUsingArray(int capacity) {
        data = new int[capacity];
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public int size() {
        return top+1;
    }
    public int top() throws StackEmptyException {
        if (size() == 0) {
            //Stack Empty Exception
//            StackEmptyException see = new StackEmptyException();
            throw new StackEmptyException();
        }
        return data[top];
    }
    public void push(int element) {
        if (size() == data.length) {
            doubleCapacity();
            //stack full
//            throw new StackFullException();
        }
        top++;
        data[top] = element;
    }
    private void doubleCapacity() {
        int[] temp = data;
        data = new int[temp.length*2];
        for (int i = 0; i <= top; i++) {
            data[i] = temp[i];
        }
    }
    public int pop() throws StackEmptyException{
        if (size() == 0) {
            //stack empty exception
            throw new StackEmptyException();
        }
        int temp = data[top];
        top--;
        return temp;
    }
}
