package queues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/*/
//https://www.youtube.com/watch?v=ptYUCjfNhJY

class MergeKSortedArrayMinheap {
    public static int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<Student> queue = new PriorityQueue<Student>(12, new ArrayContainer());
        int total = 0;

        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            queue.add(new Student(arr[i], 0));
            total = total + arr[i].length;
        }

        int m = 0;
        int result[] = new int[total];

        //while heap is not empty
        while (!queue.isEmpty()) {
            Student ac = queue.poll();
            result[m++] = ac.arr[ac.index];

            if (ac.index < ac.arr.length - 1) {
                queue.add(new Student(ac.arr, ac.index + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10};

        int[] result = mergeKSortedArray(new int[][]{arr1, arr2, arr3});
        System.out.println(Arrays.toString(result));
    }

    static class ArrayContainer implements Comparator<Student> {

        @Override
        public int compare(Student t1, Student t2) {
            if (t1.arr[t1.index] > t2.arr[t2.index])
                return 1;
            else if (t1.arr[t1.index] < t2.arr[t2.index])
                return -1;
            return 0;
        }
    }

    static class Student {
        int[] arr;
        int index;

        public Student(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }
    }
}


