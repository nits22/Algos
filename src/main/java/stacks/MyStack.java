package stacks;

import java.util.Stack;

public class MyStack {

    Stack<Integer> stack = new Stack<>();
    int maxEle;

    public void push(int value){

        if(stack.isEmpty()){
            stack.push(value);
            System.out.print("Number Inserted: " + value+ "\n");
            maxEle = value;
        }
        else if(maxEle < value){
                stack.push(2*value - maxEle);
            System.out.print("Number Inserted: " + value+ "\n");
                maxEle = value;
            }

        else if(maxEle > value){
            stack.push(value);
            System.out.print("Number Inserted: " + value+ "\n");
        }


    }

    public int getMax() {
        if (stack.empty())
            System.out.print("Stack is empty\n");

            // variable maxEle stores the maximum element
            // in the stack.
        else
            System.out.print("Maximum Element in" +
                    "the stack is: "+maxEle + "\n");

        return maxEle;
    }

    public void pop(){
        if(!stack.isEmpty()) {
            int value = stack.pop();
            if(value < maxEle){
                System.out.println("Top Most Element Removed: " + value);
            }
            else {
                System.out.println("Top Most Element Removed: " + maxEle);
                maxEle = 2 * maxEle - value;
            }
        }
    }

    public void peek(){
        if (stack.empty())
        {

            System.out.print("Stack is empty ");
            return;
        }

        int t = stack.peek(); // Top element.

        System.out.print("Top Most Element is: ");

        // If t < maxEle means maxEle stores
        // value of t.
        if(t > maxEle)
            System.out.print(maxEle);
        else
            System.out.print(t);
    }

    //7 , 5, 2*5-7

    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        s.getMax();
        s.push(7);
        s.push(19);
        s.getMax();
        s.pop();
        s.getMax();
        s.pop();
        s.peek();
    }
}