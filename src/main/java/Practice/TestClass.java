package Practice;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] S = new String[N];
        for (int i_S = 0; i_S < N; i_S++) {
            S[i_S] = br.readLine().trim();
        }

        String[] out_ = solve(S, N);
        wr.println(out_.length);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
            wr.println(out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static String[] solve(String[] S, int N) {
        // write your code here

        Map<String, Integer> map = new TreeMap();

        for(String s : S){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
            else
                map.put(s, 1);
        }

        String arr[] = new String[map.size()];
        int i = 0;
        for(String str : map.keySet()){
            arr[i] = str;
        }
        return arr;
    }
}