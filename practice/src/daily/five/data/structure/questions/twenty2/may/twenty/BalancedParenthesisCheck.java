package daily.five.data.structure.questions.twenty2.may.twenty;

import java.util.Stack;

public class BalancedParenthesisCheck {
    public static void main(String[] args) {
        String x = "({()[]}){}[()]";
        String y = "({()[])}{}[()]";
        System.out.println(isBalanced(x));
        System.out.println(isBalanced(y));

    }

    private static boolean isBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(!stk.isEmpty() && s.charAt(i) == ')') {
                if(stk.peek() == '(')
                    stk.pop();
                else return false;
            } else if(!stk.isEmpty() && s.charAt(i) == '}') {
                if(stk.peek() == '{')
                    stk.pop();
                else return false;
            } else if(!stk.isEmpty() && s.charAt(i) == ']') {
                if(stk.peek() == '[')
                    stk.pop();
                else return false;
            } else {
                stk.push(s.charAt(i));
            }
        }
        if(stk.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
