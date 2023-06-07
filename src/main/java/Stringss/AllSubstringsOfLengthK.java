package Stringss;

import java.util.ArrayList;
import java.util.List;

public class AllSubstringsOfLengthK {

    public static void main(String[] args)
    {
        String str = "leetcode";
        int length = 3;

        List<String> permutations = findPermutations(str, length);

        System.out.println("Permutations of length " + length + ":" + permutations.size());
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
    private static void printAllKLength(char[] set, int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    /* this method print all permutations with same characters of length k */
    private static void printAllKLengthRec(char[] set, String prefix, int n, int k) {

        if(k == 0){
            System.out.println(prefix);
            return;
        }
        for(int i = 0; i < n; i++){
            String newPrefix = prefix + set[i];
            printAllKLengthRec(set, newPrefix, n, k - 1);
        }
    }

    public static List<String> findPermutations(String str, int length) {
        List<String> permutations = new ArrayList<>();
        backtrack(str.toCharArray(), length, new boolean[str.length()], new StringBuilder(), permutations);
        return permutations;
    }

    private static void backtrack(char[] str, int length, boolean[] used, StringBuilder current, List<String> permutations) {
        if (current.length() == length) {
            permutations.add(current.toString());
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            current.append(str[i]);

            backtrack(str, length, used, current, permutations);

            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }
}
