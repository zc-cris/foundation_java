package chapter2;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @ClassName MemoryTest
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class MemoryTest {
    public static void main(String[] args) {

    }
}

class Stack {
    private Object[] objects;
    private int num;
    private static final int INITIAL_CAPACITY = 10;

    public Stack() {
        objects = new Object[INITIAL_CAPACITY];
    }

    public void add(Object o) {
        ensureCapacity();
        objects[++num] = o;
    }

    public Object push() {
        if (num == 0) {
            throw new EmptyStackException();
        }
        Object object = objects[--num];
        // 这句代码很关键，防止内存隐秘泄露
        objects[num] = null;
        
        return object;
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description ensure capacity is enough, roughly doubling the capacity each time the array needs to grow.
     * @Param []
     **/
    private void ensureCapacity() {
        if (num == INITIAL_CAPACITY) {
            objects = Arrays.copyOf(objects, 2 * num + 1);
        }
        
    }


}
