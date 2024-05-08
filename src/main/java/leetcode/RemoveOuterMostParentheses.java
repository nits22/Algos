package leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*https://leetcode.com/problems/remove-outermost-parentheses/*/
public class RemoveOuterMostParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));

    }

    public static String removeOuterParentheses(String s) {
        Queue<Character> st = new LinkedList<>();
        StringBuilder new_s = new StringBuilder();
        int balanced = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.add(c);
                balanced++;
            } else {
                st.add(c);
                balanced--;
            }
            if (balanced == 0) {
                st.poll();
                if (st.peek() == ')') {
                    st.clear();
                    continue;
                }
                while (!st.isEmpty()) {
                    char ch = st.poll();
                    new_s.append(ch);
                    if (st.size() == 1) {
                        st.poll();
                        break;
                    }
                }
            }
        }
        return new_s.toString();
    }

    /*This is a solution to the problem of removing outermost parentheses from a string containing only parentheses.

    The approach used is to keep track of the parentheses using a stack. Whenever an opening parenthesis is encountered,
    it is pushed onto the stack. Whenever a closing parenthesis is encountered,
    the last opening parenthesis is popped from the stack.

    If the stack size is greater than zero after pushing or popping, it means that the parenthesis is not an
    outer parenthesis, and it is added to the result string. If the stack size is zero,
    it means that the parenthesis is an outer parenthesis and it is not added to the result string.*/

    public String removeOuterParentheses1(String s) {
        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
                bracket.push(s.charAt(i));
            } else {
                bracket.pop();
                if (bracket.size() > 0) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}