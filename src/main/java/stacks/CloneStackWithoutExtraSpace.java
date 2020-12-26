package stacks;


// Java program to sort a Stack using recursion
// Note that here predefined Stack class is used
// for stack operation

import java.util.ListIterator;
import java.util.Stack;

class CloneStackWithoutExtraSpace {
    // Utility Method to print contents of stack
    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }


    public static void cloneStack(Stack<Integer> s, Stack<Integer> s1, int count) {

        while (count > 0) {
            int temp = s.pop();
            count--;
            cloneStack(s, s1, count);
            s1.push(temp);
            s.push(temp
            );
            break;
        }
    }

    // Driver method
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println("Stack elements before sorting: ");
        printStack(s);

        Stack<Integer> s1 = new Stack<>();
        cloneStack(s, s1, s.size());

        System.out.println(" \n\nStack elements after sorting:");
        printStack(s);
        System.out.println(" \n\nNew Stack elements after sorting:");
        printStack(s1);

    }
}
