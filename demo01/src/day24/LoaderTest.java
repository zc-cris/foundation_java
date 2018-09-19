package day24;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class LoaderTest {


    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test.properties"));
        Object name = properties.get("name");
        System.out.println("name = " + name);
    }
}
class Person{
    public Person(){
        System.out.println("Person = ");
    }
}
class Woman extends Person{

}
class Man extends Person{

}

