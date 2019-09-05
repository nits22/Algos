package Trees;

import java.util.LinkedList;
import java.util.Queue;


public class LeftViewTreeUsingQueue
    {

        // A Binary Tree Node
        static class node
        {
            int data;
            node left, right;
        };

        // A utility function to create a new
// Binary Tree node
        static node newNode(int item)
        {
            node temp = new node();
            temp.data = item;
            temp.left = null;
            temp.right = null;
            return temp;
        }
        static Queue<node> q;

        // Utility function to print the left view of
// the binary tree
        static void leftViewUtil( node root )
        {
            if (root == null)
                return;

            // add root
            q.add(root);

            // Delimiter
            q.add(null);

            while (q.size() > 0)
            {
                node temp = q.peek();

                if (temp != null)
                {

                    // Prints first node
                    // of each level
                    System.out.print(temp.data + " ");

                    // add children of all nodes at
                    // current level
                    while (q.peek() != null)
                    {

                        // If left child is present
                        // add into queue
                        if (temp.left != null)
                            q.add(temp.left);

                        // If right child is present
                        // add into queue
                        if (temp.right != null)
                            q.add(temp.right);

                        // remove the current node
                        q.remove();

                        temp = q.peek();
                    }

                    // add delimiter
                    // for the next level
                    q.add(null);
                }

                // remove the delimiter of
                // the previous level
                q.remove();
            }
        }

        // Fucntion to print the leftView
// of Binary Tree
        static void leftView( node root)
        {
            // Queue to store all
            // the nodes of the tree
            q = new LinkedList<node>();

            leftViewUtil(root);
        }

        // Driver Code
        public static void main(String args[])
        {
            node root = newNode(10);
            root.left = newNode(12);
            root.right = newNode(3);
            root.left.right = newNode(4);
            root.right.left = newNode(5);
            root.right.left.right = newNode(6);
            root.right.left.right.left = newNode(18);
            root.right.left.right.right = newNode(7);

            leftView(root);
        }
    }

// This code is contributed by Arnab Kundu
