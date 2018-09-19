package stack;

import java.util.Stack;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class SymbolMatch2 {
    public static void main(String[] args) {
        boolean match = match("()[]");
        System.out.println("match = " + match);
    }

    public static boolean match(String string) {
        if (string == null || "".equals(string.trim()) || string.length() % 2 != 0) {
            return false;
        }

        java.util.Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                Character pop = stack.pop();
                if (c == ')') {
                    return pop == '(';
                }
                if (c == '}') {
                    return pop == '}';
                }
                if (c == ']') {
                    return pop == ']';
                }
            }
        }
        return stack.isEmpty();
    }
}
