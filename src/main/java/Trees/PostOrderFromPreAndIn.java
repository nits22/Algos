package Trees;

import java.util.HashMap;

/*https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/?ref=rp*/
public class PostOrderFromPreAndIn {

    static int preIndex = 0;

    public static void main(String args[]) {
        int in1[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int n = in1.length;
        System.out.println("Postorder traversal ");
        printPostMain(in1, pre);
    }

    private static void printPostOrder(int[] in1, int[] pre, int start, int end, HashMap<Integer, Integer> hm) {

        if (start > end) {
            return;
        }

        int inIndex = hm.get(pre[preIndex++]);

        printPostOrder(in1, pre, start, inIndex - 1, hm);
        printPostOrder(in1, pre, inIndex + 1, end, hm);

        System.out.print(in1[inIndex] + " ");
    }

    static void printPostMain(int[] in, int[] pre) {
        int n = pre.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
            hm.put(in[i], i);

        printPostOrder(in, pre, 0, n - 1, hm);
    }
}
