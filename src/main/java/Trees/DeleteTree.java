package Trees;

/* https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/ */

 public class DeleteTree {
    /* Class containing left
    and right child of current node
    * and key value*/

    // Root of BST
    Node root;

    // Constructor
    DeleteTree() { root = null; }


    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        DeleteTree tree = new DeleteTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
		20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(
                "Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
    }

    private void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {

        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while(root.left!= null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    private void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
       /* If the tree is empty,
          return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

     class Node {
         int key;
         Node left, right;

         public Node(int item)
         {
             key = item;
             left = right = null;
         }
     }
}

