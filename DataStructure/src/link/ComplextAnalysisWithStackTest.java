package link;

import org.junit.Test;
import stack.MyArrayStack;
import stack.Stack;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * compare the efficiency of normal stack complement by dynamic array and link stack complement by linkList
 *
 * @author zc-cris
 * @version 1.0
 **/
public class ComplextAnalysisWithStackTest {

    @Test
    public void test() {
//        time = 0.109958768
        double time = getTime(new MyArrayStack<>(), 1000000);
        System.out.println("time = " + time);

//        time = 0.334306442
        double time2 = getTime(new LinkListStack<>(), 1000000);
        System.out.println("time = " + time2);
    }

    public double getTime(Stack<Integer> stack, int count) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int j = 0; j < count; j++) {
            int i = random.nextInt(Integer.MAX_VALUE);
            stack.push(j);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }

    public double getTime2(Stack<Integer> stack, int count) {
        Random random = new Random();
        Instant start = Instant.now();
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(Integer.MAX_VALUE);
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        Instant end = Instant.now();
        return Duration.between(start, end).toSeconds();
    }

    @Test
    public void test2() {
//        time2 = 0.0
        double time2 = getTime2(new MyArrayStack<>(), 10000000);
        System.out.println("time2 = " + time2);

//        time21 = 3.0
        double time21 = getTime2(new LinkListStack<>(), 10000000);
        System.out.println("time21 = " + time21);
    }
}