package Practice;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTreeTraversal {

    public static class Node{
        int key;
        Node left, right;

    public Node(int key){
            this.key = key;
            left = right = null;
        }
    }

    static Queue<Node> queue = new LinkedList<Node>();
    public static void leftViewUtil(Node node){
        queue.add(node);

        queue.add(null);
        while(queue.size() > 0){
            if(queue.peek() == null){
                queue.poll();
                continue;
            }
            System.out.print(queue.peek().key + " ");

            Node n_node = queue.peek();
            while(n_node != null){
                if(n_node.left != null)
                    queue.add(n_node.left);
                if(n_node.right != null)
                    queue.add(n_node.right);

                queue.poll();
                n_node = queue.peek();
            }

            queue.add(null);
        }

    }

    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
        root.right.left.right.left = new Node(18);
        root.right.left.right.right = new Node(7);

        leftViewUtil(root);
    }

}
