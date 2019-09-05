package Practice;

import java.util.Arrays;

public class FindNextLargestNumber {


    public int nextLargestNum(int num){

        char[] ch  = String.valueOf(num).toCharArray();

        int number[] = getIntegerArray(ch);
        int len = number.length-1;
         int i;
        for(i = len; i > 0; i --) {
            if (number[i - 1] < number[i]) {
                break;
            }
        }
            if(i == 0)
                System.out.println("No greater number possible");

            int x = number[i -1]; int min = i;
            int j = i+1;
            for(; j <= len; j ++ ){
                if(number[j] > x && number[j] < number[min])
                    min = j;
            }

            swapNumbers(number, i -1, min);

            Arrays.sort(number, i, len+1);

        return convertToInt(number);
    }

    public static void main(String[] args) {
        int num = 90998;
//90998 --> 98099
        FindNextLargestNumber fnln = new FindNextLargestNumber();
        System.out.println(fnln.nextLargestNum(num));


    }

    public static int convertToInt(int [] nums){
        StringBuilder strNum = new StringBuilder();

        for (int num : nums)
        {
            strNum.append(num);
        }
        int finalInt = Integer.parseInt(strNum.toString());

        return finalInt;
    }


    public int[] getIntegerArray(char [] ch){

        int[] intArray = new int[ch.length];

        //Loop through each element of char array to the integer array
        for (int i = 0; i < ch.length; i++) {

            intArray[i] = (int)ch[i] - 48;
        }

        return intArray;
    }

    public int[] swapNumbers(int [] number, int i, int j){
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
        return number;
    }
}
