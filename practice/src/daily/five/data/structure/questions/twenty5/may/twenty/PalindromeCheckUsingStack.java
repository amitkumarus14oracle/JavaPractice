package daily.five.data.structure.questions.twenty5.may.twenty;

import java.util.Stack;

public class PalindromeCheckUsingStack {
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("abcdedcba");
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(String input) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        int length = input.length();
        while(i < length/2) {
            s.push(input.charAt(i));
            i++;
        }
        if(length%2 != 0) {
            i++;
        }
        while(i < length) {
            if(s.pop() != input.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
