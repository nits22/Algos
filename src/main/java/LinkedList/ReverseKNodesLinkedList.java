package LinkedList;

// Java implementation to print the last k nodes
// of linked list in reverse order  https://www.geeksforgeeks.org/print-the-last-k-nodes-of-the-linked-list-in-reverse-order/
public class ReverseKNodesLinkedList {

    // Structure of a node
    static class Node {
        int data;
        Node next;
    }

    // Function to get a new node
    static Node getNode(int data) {
        // allocate space
        Node newNode = new Node();

        // put in data
        newNode.data = data;
        newNode.next = null;
        return newNode;
    }

    static class C {
        int count = 0;
    }

    // Function to print the last k nodes
// of linked list in reverse order
    static void printLastKRev(Node head, C c, int k) {
        // if list is empty
        if (head == null)
            return;

        printLastKRev(head.next, c, k);
        c.count++;
        if (c.count <= k) {
            System.out.print(head.data + " ");
        }


    }

    // Driver code
    public static void main(String[] args) {
        // Create list: 1->2->3->4->5
        Node head = getNode(1);
        head.next = getNode(2);
        head.next.next = getNode(3);
        head.next.next.next = getNode(4);
        head.next.next.next.next = getNode(5);

        int k = 4;
        C c = new C();

        // print the last k nodes
        printLastKRev(head, c, k);
    }
}

// This code is contributed by prerna saini
