package leetcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(sherlockAndAnagrams("kkkk")); //10 , cdcd = 5
    }

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> track = new HashMap<>();
        int index;
        int sublen = 0;
        while (sublen < s.length()) {
            index = sublen+1;
            while (index <= s.length()) {
                String substring = s.substring(sublen, index)
                        .chars()
                        .mapToObj(ch->(char) ch)
                        .sorted().map(String::valueOf)
                        .collect(Collectors.joining());
                int occurrence = track.getOrDefault(substring, 0);
                occurrence++;
                track.put(substring, occurrence);
                index++;
            }
            sublen++;
        }
        return track.values().stream().filter(v -> v >=2).map(value -> value * (value -1)/2).mapToInt(v -> v).sum();
    }
}
