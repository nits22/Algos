package LinkedList;

import LinkedList.ReverseLinkedListStack.Node;

public class ReverseLinkedListBetweenNodes {
        public static Node reverseBetween(Node head, int m, int n) {
            if (head==null) {
                return null;
            }

            Node dummy = new Node(0);
            dummy.next = head;
            head = dummy;

            for (int i=1; i<m; i++) {
                head = head.next;
            }

            Node prev = head;
            Node end = head.next;
            Node start = end;
            Node curr = end.next;
            Node temp;

            for (int i=m; i<n; i++) {
                if (start==null) {
                    return null;
                }
                temp = curr.next;
                curr.next = start;
                start = curr;
                curr = temp;
            }

            prev.next = start;
            end.next = curr;

            return dummy.next;
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


        reverseBetween(head, 2,4);

        printList(head);
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

    // Function to print the Linked list
    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}