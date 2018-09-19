package day24;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class ExamTest {
    public static void main(String[] args) {
    }

    @Test
    public void test() throws IOException {
        Set<String> set1 = new HashSet<>() {
            {
                add("绍兴市");
                add("温州市");
                add("台州市");
            }
        };
        Set<String> set2 = new HashSet<>() {
            {
                add("海口市");
                add("三亚市");
            }
        };
        Set<String> set3 = new HashSet<>() {
            {
                add("北京市");
            }
        };
        Map<String, Set<String>> cities = new HashMap<>(5) {
            {
                put("浙江省", set1);
                put("海南省", set2);
                put("北京市", set3);
            }
        };
        cities.forEach((k, v) -> System.out.println(k + "\n" + v));
    }

}


