package array;

import org.junit.Test;

import java.util.Arrays;


/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class MyArrayTest {

    @Test
    public void test1() {
        MyArray<String> myArray = new MyArray<>() {
            {
                addFirst("james");
                addLast("simida");
            }
        };
        for (int i = 0; i < 10; i++) {
            myArray.addLast("i" + i);
        }
        System.out.println("myArray = " + myArray);
        myArray.remove(1);
        System.out.println("myArray = " + myArray);
        myArray.removeElement("james");
        System.out.println("myArray = " + myArray);
        myArray.addLast("simida");
        myArray.addLast("curry");
        myArray.addLast("simida");
        int[] ints = myArray.indexOfAll("simida");
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        System.out.println("myArray = " + myArray);
        boolean simida = myArray.removeAllElement("simida");
        System.out.println("simida = " + simida);
        System.out.println("myArray = " + myArray);

    }
}
