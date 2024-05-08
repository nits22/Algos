package Array;

/*https://www.youtube.com/watch?v=BBt9FB5Yt0M
* Merge K Sorted Lists - Divide and Conquer Approach */
public class MergeKSortedArraysDivideAndConquer2 {


    static class Node {
        static Node head;
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        Node() {
        }
    }


    public static void main(String[] args) {
        Node list = new Node(2);
        list.next = new Node(5);
        list.next.next = new Node(15);
        list.next.next.next = new Node(20);
        list.next.next.next.next = new Node(40);


        Node list1 =  new Node(3);
        list1.next = new Node(21);
        list1.next.next = new Node(31);


        Node list2 = new Node(1);
        list2.next = new Node(31);
        list2.next.next = new Node(41);
        list2.next.next.next = new Node(60);


        Node[] newlist = {list, list1, list2};

        Node node = mergeKList(newlist);

        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private static Node mergeKList(Node[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        return mergeKList(list, 0, list.length - 1);
    }

    private static Node mergeKList(Node[] list, int start, int end) {
        if (start == end) return list[start];

        int mid = start + (end - start) / 2;

        Node left = mergeKList(list, start, mid);
        Node right = mergeKList(list, mid + 1, end);

        return merge(left, right);

    }

    private static Node merge(Node l1, Node l2) {
        Node result = new Node(-1);
        Node curr = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        return result.next;
    }

}
