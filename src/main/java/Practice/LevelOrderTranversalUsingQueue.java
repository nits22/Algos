package Practice;



import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTranversalUsingQueue {

    static Queue<LeftViewTreeTraversal.Node> queue = new LinkedList<LeftViewTreeTraversal.Node>();

    public static void levelOrder(LeftViewTreeTraversal.Node node){
        queue.add(node);

        while(queue.size() > 0){

            System.out.print(queue.peek().key + " ");

            LeftViewTreeTraversal.Node n_node = queue.peek();
            if(n_node != null){
                if(n_node.left != null)
                    queue.add(n_node.left);
                if(n_node.right != null)
                    queue.add(n_node.right);

            }
            queue.poll();

        }

    }

    public static void main(String args[])
    {
        LeftViewTreeTraversal.Node root = new LeftViewTreeTraversal.Node(10);
        root = new LeftViewTreeTraversal.Node(1);
        root.left = new LeftViewTreeTraversal.Node(2);
        root.right = new LeftViewTreeTraversal.Node(3);
        root.left.left = new LeftViewTreeTraversal.Node(4);
        root.left.right = new LeftViewTreeTraversal.Node(5);

        levelOrder(root);
    }

}
