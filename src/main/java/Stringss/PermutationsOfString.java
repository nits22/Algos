package Stringss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//if string doesn't have duplicates
public class PermutationsOfString {
    public static void main(String[] args) {
        System.out.println(permuteUnique("let".toCharArray()));
    }
    public static List<String> permuteUnique(char[] nums) {
        List<String>  list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new StringBuilder(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<String> list, StringBuilder sb, char[] ch, boolean [] used){
        if(sb.length() == ch.length){
            list.add(sb.toString());
        } else{
            for(int i = 0; i < ch.length; i++){
                if(used[i]) continue;
                used[i] = true;
                sb.append(ch[i]);
                backtrack(list, sb, ch, used);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
