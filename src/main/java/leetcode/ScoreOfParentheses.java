package leetcode;

import java.util.Stack;

/*https://leetcode.com/problems/score-of-parentheses/description/*/
class ScoreOfParentheses {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()())"));
    }

    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}