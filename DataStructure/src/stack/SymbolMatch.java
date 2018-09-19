package stack;

/**
 * 使用循环的方式解决Leetcode 的符号匹配问题
 *
 * @author zc-cris
 * @version 1.0
 **/
public class SymbolMatch {
    public static void main(String[] args) {
        boolean solution = solution("[{)]");
        System.out.println("solution = " + solution);
    }

    public static boolean solution(String string) {
        if (string == null || "".equals(string.trim()) || string.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < string.length() / 2; i++) {
            if (!(match(string.charAt(i), string.charAt(string.length() - 1 - i)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean match(char c, char c1) {
        boolean flag = true;
        switch (c) {
            case '(':
                if (c1 != ')') {
                    flag = false;
                }
                break;
            case '{':
                if (c1 != '}') {
                    flag = false;
                }
                break;
            case '[':
                if (c1 != ']') {
                    flag = false;
                }
                break;
            default:
                flag = false;
        }
        return flag;
    }
}
