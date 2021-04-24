package Trees;

/* https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/ */
public class ConstructTreeFromPreAndIn {
// Java program to construct a tree using inorder and preorder traversal

    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static int preIndex = 14;

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        /* Recursive function to construct binary of size len from
        Inorder traversal in[] and Preorder traversal pre[].
        Initial values of inStrt and inEnd should be 0 and len -1.
        The function doesn't do any error checking for cases where
        inorder and preorder do not form a tree */
        Node buildTree(int in[], int pre[], int inStrt, int inEnd) {
            if (inStrt > inEnd)
                return null;

		/* Pick current node from Preorder traversal using preIndex
		and increment preIndex */
            Node tNode = new Node(pre[preIndex--]);

            /* If this node has no children then return */
            if (inStrt == inEnd)
                return tNode;

            /* Else find the index of this node in Inorder traversal */
            int inIndex = search(in, inStrt, inEnd, tNode.data);

		/* Using index in Inorder traversal, construct left and
		right subtress */
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
            tNode.left = buildTree(in, pre, inStrt, inIndex - 1);


            return tNode;
        }

        /* UTILITY FUNCTIONS */

        /* Function to find index of value in arr[start...end]
        The function assumes that value is present in in[] */
        int search(int arr[], int strt, int end, int value) {
            int i;
            for (i = strt; i <= end; i++) {
                if (arr[i] == value)
                    return i;
            }
            return i;
        }

        /* This funtcion is here just to test buildTree() */
        void printPreorder(Node node) {
            if (node == null)
                return;

            /* then print the data of node */
            System.out.print(node.data + " ");

            /* first recur on left child */
            printPreorder(node.left);

            /* now recur on right child */
            printPreorder(node.right);
        }

        // driver program to test above functions
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            int in[] = {4, 10, 12, 15, 18, 22, 24, 25,
                    31, 35, 44, 50, 66, 70, 90};
            int post[] = {4, 12, 10, 18, 24, 22, 15, 31,
                    44, 35, 66, 90, 70, 50, 25};
            int len = in.length;
            Node root = tree.buildTree(in, post, 0, len - 1);

            // building the tree by printing inorder traversal
            System.out.println("Inorder traversal of constructed tree is : ");
            tree.printPreorder(root);
        }
    }

// This code has been contributed by Mayank Jaiswal
}