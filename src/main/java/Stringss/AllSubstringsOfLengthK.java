package Stringss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubstringsOfLengthK {

    public static void main(String[] args) {
        String str = "leetcode";
        int length = 3;

        List<String> permutations = findPermutations(str, length);

        System.out.println("Permutations of length " + length + ":" + permutations.size());
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<String> findPermutations(String str, int length) {
        List<String> permutations = new ArrayList<>();
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        backtrack(ch, new boolean[str.length()], new StringBuilder(), permutations, length);
        return permutations;
    }

    private static void backtrack(char[] nums, boolean[] used, StringBuilder curr, List<String> res, int k) {
        // If the current permutation is complete, add it to the results list
        if (curr.length() == k) {
            res.add(curr.toString());
            return;
        }

        // Loop through the indices of the input array
        for (int i = 0; i < nums.length; i++) {
            // Skip if the number has already been used or if it's a duplicate that has already been used
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            // Mark the current number as used, add it to the current permutation list
            used[i] = true;
            curr.append(nums[i]);
            backtrack(nums, used, curr, res, k);
            used[i] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
