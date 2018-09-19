package day18;

import java.util.List;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class TestDemo2 {
    public static void main(String[] args) {
        List<Integer> list = TestDemo.LIST;
        Integer integer = list.get(0);
        integer = 2323;
        System.out.println("TestDemo.LIST = " + list);

    }
}
