public class Solution {

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        long result = 0; 

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.myAtoi("42"));         
        System.out.println(sol.myAtoi("   -042"));     
        System.out.println(sol.myAtoi("1337c0d3"));    
        System.out.println(sol.myAtoi("0-1"));         
        System.out.println(sol.myAtoi("words 987"));   
    }
}