package ideapractice;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(45);
        integers.add(3);

        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
        System.out.println("integers = " + integers);

    }
}
