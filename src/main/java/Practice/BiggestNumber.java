package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
public class BiggestNumber {

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();

        //output should be 6054854654
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);
    }

    public static void printLargest(List<String> list) {

        Collections.sort(list, new MyComparator());

        for(String i : list)
            System.out.print(i + " ");

    }
}

     class MyComparator implements Comparator {


         @Override
         public int compare(Object o1, Object o2) {
             String s1 = (String) o1;
             String s2 = (String) o2;
             if(s1.length() < s2.length() ){
                 int size = s1.length();
                 int a = Integer.parseInt(s1.substring(0, size));
                 int b = Integer.parseInt(s2.substring(0, size));
                 if((b == a && s2.length() > s1.length()) || a > b)
                     return -1;
                 else
                     return 1;
             }
             else{
                 int size = s2.length();
                 int a = Integer.parseInt(s1.substring(0, size));
                 int b = Integer.parseInt(s2.substring(0, size));
                 if((b == a && s1.length() > s2.length()) || a > b)
                     return -1;
                 else
                     return 1;
             }
         }
     }

/*
Collections.sort(arr, new Comparator<String>(){

        // A comparison function which is used by
        // sort() in printLargest()
        @Override
        public int compare(String X, String Y) {

        // first append Y at the end of X
        String XY=X + Y;

        // then append X at the end of Y
        String YX=Y + X;

        // Now see which of the two formed numbers
        // is greater
        return XY.compareTo(YX) > 0 ? -1:1;
    }
    });
 */
