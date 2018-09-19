package day13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        fun();
        fun2();
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 将字符串内容反转
     * @Param []
     **/
    public static void fun() {
        String str = "123str";
        int middle = str.length() / 2;
        char[] chars = str.toCharArray();
        int lengh = chars.length;
        for (int i = 0; i < middle; i++) {
            char temp = chars[i];
            chars[i] = chars[lengh - 1 - i];
            chars[lengh - 1 - i] = temp;
        }
        System.out.println("String.valueOf(chars) = " + String.valueOf(chars));
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 将包装类字符数组利用Stream API 排序
     * @Param []
     **/
    private static void fun1() {
        Character[] a = {'v', 'e', 'd'};
        List<Character> collect = Arrays.stream(a).sorted(Character::compareTo).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 利用Arrays工具类对字符基本类型排序
     * @Param []
     **/
    public static void fun2() {
        String str = "342567891";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
    }
}
