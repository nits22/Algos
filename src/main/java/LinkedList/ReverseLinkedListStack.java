package LinkedList;

import java.util.Stack;

public class ReverseLinkedListStack {


    /* Link list node */
    static class Node
    {
        int data;
        Node next;
        Node(int key){
            this.data = key;
            next = null;
        }
    }
    static Node head = null;

    /* Given a reference (pointer to pointer) to
    the head of a list and an int, push a new
    node on the front of the list. */
    static void push( int new_data)
    {
        Node new_node = new Node(new_data);

        new_node.next = (head);
        (head) = new_node;
    }

    // Function to reverse linked list
    static Node reverseList(Node head)
    {
        // Stack to store elements of list
        Stack<Node > stk = new Stack<Node> ();

        // Push the elements of list to stack
        Node ptr = head;
        while (ptr.next != null)
        {
            stk.push(ptr);
            ptr = ptr.next;
        }

        // Pop from stack and replace
        // current nodes value'
        head = ptr;
        while (!stk.isEmpty())
        {
            ptr.next = stk.peek();
            ptr = ptr.next;
            stk.pop();
        }
        ptr.next = null;

        return head;
    }

    // Function to print the Linked list
    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        /* Start with the empty list */
        //Node head = null;

	/* Use push() to construct below list
	1->2->3->4->5 */
        push( 5);
        push( 4);
        push( 3);
        push( 2);
        push( 1);

        head = reverseList(head);

        printList(head);
    }
}

// This code is contributed by Prerna Saini.
