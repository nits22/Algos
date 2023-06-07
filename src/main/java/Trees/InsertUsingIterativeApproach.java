package Trees;

import java.util.Stack;

public class InsertUsingIterativeApproach {

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(30);
        tree.insert(50);
        tree.insert(15);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);
        tree.inorder();
    }
}

class Node1 {
    Node1 left;
    int val;
    Node1 right;

    Node1(int val) {
        this.val = val;
    }
}

class BST {
    Node1 root;

    public void insert(int key) {
        Node1 node = new Node1(key);
        if (root == null) {
            root = node;
            return;
        }
        Node1 prev = null;
        Node1 temp = root;
        while (temp != null) {
            if (temp.val > key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.val < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.val > key)
            prev.left = node;
        else
            prev.right = node;
    }

    public void inorder() {
        Node1 temp = root;
        Stack<Node1> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.val + " ");
                temp = temp.right;
            }
        }
    }
}