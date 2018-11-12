// Given n pairs of parentheses, print all valid combinations 

import java.util.*;

public class Parens {

    // Add parens that keep the string valid
    public static List<String> parens(int n){
        char[] str = new char[n + n];
        List<String> combos = new ArrayList<>();
        parens(n, n, 0, str, combos);
        return combos;
    }

    public static void parens(int lefts, int rights, int index, char[] str, List<String> combos) {
        // Invalid if we have fewer rights than lefts remaining
        if (rights < lefts) {
            return;
        }

        // Invalid if we dont have any lefts remaining
        if (lefts < 0) {
            return;
        }


        if (rights == 0 && lefts == 0) {
            String finalString = String.copyValueOf(str);
            combos.add(finalString);
            return;
        }

        str[index] = '(';
        parens(lefts - 1, rights, index + 1, str, combos);

        str[index] = ')';
        parens(lefts, rights - 1, index + 1, str, combos);


    }

    // Driver
    public static void main(String[] args) {
        int n = 3;
        List<String> combos = parens(n);

        for (String s : combos) {
            System.out.println(s);
        }
    }
}