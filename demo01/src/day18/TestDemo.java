package day18;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class TestDemo {


    private static final Integer[] ARRAY = {1, 2, 3, 4};
    public static final List<Integer> LIST = List.of(ARRAY);

    public static Integer[] getArray() {
        return ARRAY.clone();
    }

    @SuppressWarnings({"unused", "UnusedAssignment"})
    public static void main(String[] args) {

        Integer[] array = TestDemo.getArray();
        array[0] = 343;
        // [343, 2, 3, 4]
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
//        [1, 2, 3, 4]
        System.out.println("Arrays.toString(TestDemo.getArray()) = " + Arrays.toString(TestDemo.getArray()));

      /*  List<Integer> list = TestDemo.LIST;
        Integer integer = list.get(0);
        integer = 2323;
        // TestDemo.LIST = [1, 2, 3, 4]
        System.out.println("TestDemo.LIST = " + list);*/
    }
}
