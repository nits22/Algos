package stacks;

import java.util.ListIterator;
import java.util.Stack;

public class SortStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);

        System.out.println(
                "Stack elements before sorting: ");
        printStack(s);

        sortStack(s);

        System.out.println(
                " \n\nStack elements after sorting:");
        printStack(s);
    }

    private static void sortStack(Stack<Integer> s) {

        if(!s.isEmpty()){
            int temp = s.pop();
            sortStack(s);
            sortedInsert(s, temp);
        }

    }

    public static void sortedInsert(Stack<Integer> s, int e){

        if(s.isEmpty() || e > s.peek())
            s.push(e);
        else{
            int t = s.pop();
            sortedInsert(s, e);
            s.push(t);
        }
    }

    private static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();

        // forwarding
        while (lt.hasNext())
            lt.next();

        // printing from top to bottom
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }
}
