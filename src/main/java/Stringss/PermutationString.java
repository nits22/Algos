package Stringss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PermutationString {
    public static ArrayList<String> s = new ArrayList<String>();

    public static void main(String[] args) {
//code
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();

        while (q-- > 0) {
            String str = scan.next();
            fun(str, 0, str.length() - 1);

            Collections.sort(s);
            for (String i : s)
                System.out.print(i + " ");

            System.out.println("");
            s.clear();
        }
    }

    public static void fun(String str, int l, int r) {
        if (l == r) {
            s.add(str);
            return;
        }
        for (int i = l; i <= r; ++i) {
            str = swap(str, l, i);
            fun(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    public static String swap(String s, int i, int j) {
        char[] a = s.toCharArray();
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return String.valueOf(a);
    }
}
