package leetcode;

//import javafx.util.Pair;

public class LargetstRectangleHistogram {
    /*public static void main(String[] args) {
        int a = largestRectangleArea(new int[]{2,1,5,6,2,3});
        System.out.println(a);

    }

    public static int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        int start;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int curHt = heights[i];
            start = i;
            while (!stack.isEmpty() && stack.peek().getValue() > curHt) {
                Pair<Integer, Integer> pair = stack.pop();
                int index = pair.getKey();
                int h = pair.getValue();
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(new Pair(start, curHt));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int index = pair.getKey();
            int h = pair.getValue();
            area = Math.max(area, h * (n - index));
        }
        return area;
    }*/
}
