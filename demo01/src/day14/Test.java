package day14;

import java.util.Objects;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Test {
    private String name;
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("test.getClass() == Test.class = " + (test.getClass() == Test.class));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
