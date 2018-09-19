package day20;

import java.util.*;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class DemoTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {
                add("ji");
                add("cris");
                add("james");
                add("simida");
            }
        };
        list.removeIf(x -> x.length() < 5);
        list.replaceAll(String::toUpperCase);
        list.forEach(System.out::println);

//        list.stream().max(Comparator.comparingInt(String::length));
        
        TreeSet<Person> set = new TreeSet<>(Comparator.comparingInt(Person::getAge)){
            {
                add(new Person(23, "james"));
                add(new Person(11, "james"));
                add(new Person(11, "cris"));
            }
        };


        for (Person person : set) {
            System.out.println("person = " + person);
        }

        Map<String, String> map = new HashMap<>(2) {
            {
                put("age", "123");
                put("name", "james");
            }
        };
        map.forEach((k, v) -> System.out.println("k :" + k + ", v :" + v));
    }
}
