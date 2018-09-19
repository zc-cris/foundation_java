package day20;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class Demo3Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.forEach(System.out::println);
    }
}
