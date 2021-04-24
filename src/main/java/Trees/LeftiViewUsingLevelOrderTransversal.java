package Trees;

public class LeftiViewUsingLevelOrderTransversal {
// Recursive Java program for level
// order traversal of Binary Tree

    /* Class containing left and right child of current
    node and key value*/
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        // Root of the Binary Tree
        Node root;

        public BinaryTree() {
            root = null;
        }

        /* function to print level order traversal of tree*/
        void printLevelOrder() {
            int h = height(root);
            int i;
            for (i = 1; i <= h; i++)
                printGivenLevel(root, i, true);
        }

        /* Compute the "height" of a tree -- the number of
        nodes along the longest path from the root node
        down to the farthest leaf node.*/
        int height(Node root) {
            if (root == null)
                return 0;
            else {
                /* compute height of each subtree */
                int lheight = height(root.left);
                int rheight = height(root.right);

                /* use the larger one */
                if (lheight > rheight)
                    return (lheight + 1);
                else return (rheight + 1);
            }
        }

        /* Print nodes at the given level */
        boolean printGivenLevel(Node root, int level, boolean flag) {
            if (root == null)
                return false;
            if (level == 1 && flag == true) {
                System.out.print(root.data + " ");
                flag = false;
                return flag;
            } else if (level > 1) {
                if (root.left != null)
                    flag = printGivenLevel(root.left, level - 1, flag);
                if (root.right != null)
                    printGivenLevel(root.right, level - 1, flag);
            }
            return flag;
        }

        /* Driver program to test above functions */
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(10);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(7);
            tree.root.left.right = new Node(8);
            tree.root.right.right = new Node(15);
            tree.root.right.left = new Node(12);
            tree.root.right.right.left = new Node(14);

            System.out.println("Level order traversal of binary tree is");
            tree.printLevelOrder();
        }
    }
}