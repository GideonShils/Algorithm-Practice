// Reverse a string in place without using a built in function

import java.util.*;

public class ReverseString {
	static String reverse(String str) {
       char[] s = str.toCharArray();

       for (int i = 0; i < s.length/2; i++) {
           char temp = s[i];
           s[i] = s[s.length-i-1];
           s[s.length-i-1] = temp;
       }

       return new String(s);
    }
 
	public static void main(String args[]) {
        String str = "Test";
        System.out.println(reverse(str));
	}
}