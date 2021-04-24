package Practice;

/*https://www.geeksforgeeks.org/print-elements-sorted-order-row-column-wise-sorted-matrix/*/
// A Java program to Print all elements
// in sorted order from row and
// column wise sorted matrix
class SortMatrix
{
    static final int INF = Integer.MAX_VALUE;
    static final int N = 4;

    // A utility function to youngify a Young Tableau.
    // This is different from standard youngify.
    // It assumes that the value at mat[0][0] is infinite.
    static void youngify(int mat[][], int i, int j)
    {
        // Find the values at down and right sides of mat[i][j]
        int downVal = (i + 1 < N) ?
                mat[i + 1][j] : INF;
        int rightVal = (j + 1 < N) ?
                mat[i][j + 1] : INF;

        // If mat[i][j] is the down right corner element,
        // return
        if (downVal == INF && rightVal == INF)
        {
            return;
        }

        // Move the smaller of two values
        // (downVal and rightVal) to mat[i][j]
        // and recur for smaller value
        if (downVal < rightVal)
        {
            mat[i][j] = downVal;
            mat[i + 1][j] = INF;
            youngify(mat, i + 1, j);
        }
        else
        {
            mat[i][j] = rightVal;
            mat[i][j + 1] = INF;
            youngify(mat, i, j + 1);
        }
    }

    // A utility function to extract
    // minimum element from Young tableau
    static int extractMin(int mat[][])
    {
        int ret = mat[0][0];
        mat[0][0] = INF;
        youngify(mat, 0, 0);
        return ret;
    }

    // This function uses extractMin()
    // to print elements in sorted order
    static void printSorted(int mat[][])
    {
        System.out.println("Elements of matrix in sorted order n");
        for (int i = 0; i < N * N; i++)
        {
            System.out.print(extractMin(mat) + " ");
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},};
        printSorted(mat);
    }
}

// This code is contributed by Rajput-Ji
//https://www.geeksforgeeks.org/merge-k-sorted-arrays/

// Java program to merge k sorted arrays of size n each.

/*import java.io.*;
        import java.util.*;

class GFG {

    // This function takes an array of arrays as an argument
    // and
    // All arrays are assumed to be sorted. It merges them
    // together and prints the final sorted output.
    public static void mergeKArrays(int[][] arr, int a,
                                    int[] output)
    {
        int c = 0;

        // traverse the matrix
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 4; j++)
                output[c++] = arr[i][j];
        }

        // sort the array
        Arrays.sort(output);
    }

    // A utility function to print array elements
    public static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int[][] arr = { { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 } };
        int k = 4;
        int n = 3;
        int[] output = new int[n * k];

        mergeKArrays(arr, n, output);

        System.out.println("Merged array is ");
        printArray(output, n * k);
    }
}*/
