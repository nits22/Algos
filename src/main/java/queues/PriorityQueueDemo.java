package queues;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    // Main Method
    public static void main(String args[]) {
        // Creating empty priority queue
        PriorityQueue<ArrayContainer> pQueue = new PriorityQueue<ArrayContainer>();

        // Adding items to the pQueue using add()
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        pQueue.add(new ArrayContainer(arr1, 0));
        pQueue.add(new ArrayContainer(arr2, 0));
        pQueue.add(new ArrayContainer(arr3, 0));
    }
}

class ArrayContainer implements Comparable<ArrayContainer> {
    int[] arr;
    int index;

    public ArrayContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayContainer o) {
        return this.arr[this.index] - o.arr[o.index];
    }
}
