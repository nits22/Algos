package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightViewTree {

    static class Nodee {
        int val;
        Nodee left, right;
        public Nodee(int item)
        {
            val = item;
            left = right = null;
        }
    }


    public static List<Integer> rightSideView(Nodee root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        bfs(list, root);
        return list;
    }

    public static void bfs(List<Integer> list, Nodee root) {
        Queue<Nodee> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Nodee cur = q.poll();
                if (i == 0) list.add(cur.val);
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }
    }

    public static void main(String args[])
    {
        RightViewTree.Nodee root = new Nodee(1);
        root.left = new Nodee(2);
        root.right = new Nodee(3);
        root.left.right = new Nodee(5);
        root.right.right = new Nodee(4);
        root.left.right.left = new Nodee(7);
        System.out.println(rightSideView(root));
    }
}
