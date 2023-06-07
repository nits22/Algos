package LinkedList;

public class IntersectionPoint2LinkedList {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Inserts a new Node at front of the list. */
    IntersectionPoint2LinkedList push(IntersectionPoint2LinkedList list, int new_data) {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        Node new_node = new Node(new_data);
        if (head == null)
            head = new_node;
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        IntersectionPoint2LinkedList llist1 = new IntersectionPoint2LinkedList();
        IntersectionPoint2LinkedList llist2 = new IntersectionPoint2LinkedList();
        llist1.push(llist1, 10);
        llist1.push(llist1, 15);
        llist1.push(llist1, 30);


        System.out.println("First Linked List:");
        llist1.printList();

        llist2.push(llist2, 3);
        llist2.push(llist2, 6);
        llist2.push(llist2, 9);
        llist2.push(llist2, 15);
        llist2.push(llist2, 30);

        System.out.println("Second Linked List:");
        llist2.printList();

        System.out.println(llist1.findIntersectionPoint(llist1, llist2));

    }

    private int findIntersectionPoint(IntersectionPoint2LinkedList llist1, IntersectionPoint2LinkedList llist2) {
        int n1 = getSize(llist1);
        int n2 = getSize(llist2);
        if (n1 > n2) {
            int d1 = n1 - n2;
            return findPoint(d1, llist1, llist2);
        } else {
            int d2 = n2 - n1;
            return findPoint(d2, llist2, llist1);
        }

    }

    private int findPoint(int d, IntersectionPoint2LinkedList llist1, IntersectionPoint2LinkedList llist2) {
        Node current1 = llist1.head;
        Node current2 = llist2.head;
        for (int i = 0; i < d; i++) {
            current1 = current1.next;
        }
        while (current1.data != current2.data) {
            current1 = current1.next;
            current2 = current2.next;
        }
        if (current1.data == current2.data)
            return current1.data;

        return -1;
    }

    private int getSize(IntersectionPoint2LinkedList list) {
        int count = 0;
        Node curr = list.head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }
}
