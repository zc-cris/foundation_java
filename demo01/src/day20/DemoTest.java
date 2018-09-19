package day20;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class DemoTest {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        int[] ints = Arrays.copyOf(array, array.length);
        System.out.println("(ints==array) = " + (ints==array));
        ints[0] = 32;
        
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
        for (int i : array) {
            System.out.println("i = " + i);
        }

        Person[] persons = {new Person(12, "cris"), new Person(22, "james")};
        Person[] people = Arrays.copyOf(persons, persons.length);
        people[0].setAge(60).setName("simida");
        System.out.println("people==persons = " + (people == persons));
        for (Person person : persons) {
            System.out.println("person = " + person);
        }
        for (Person person : people) {
            System.out.println("person = " + person);
        }
    }
}
