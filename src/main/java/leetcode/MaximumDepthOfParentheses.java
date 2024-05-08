package leetcode;
/*https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/*/
public class MaximumDepthOfParentheses {
    public static void main(String[] args) {
        System.out.println(maxDepth("(()())"));
    }

    public static int maxDepth(String s) {
        int upcount = 0;
        int downcount = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                upcount++;
            }
            ans = Math.max(ans, upcount);
            if (s.charAt(i) == ')') {
                upcount--;
            }

        }
        return ans;
    }
}
