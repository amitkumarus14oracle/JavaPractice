package leetcode.daily.question;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        Integer i = x;
        String o = i.toString();
        boolean isNegative = false;
        if(o.charAt(0) == '-') {
            isNegative = true;
            o = o.substring(1);
        }
        StringBuffer s = new StringBuffer(o);
        StringBuffer revS = s.reverse();
        long l = Long.parseLong(revS.toString());
        if(isNegative) {
            l = l*(-1);
        }
        if(l >=Math.pow(-2, 31) && l <= (Math.pow(2, 31) -1)) {
            return (int)l;
        }
        return 0;
    }
}
