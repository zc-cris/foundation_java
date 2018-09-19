package day22;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

/**
 * 注意这里通过模块的方式构建的工程，无法使用main方法读取到模块根路径下的文件，但是使用@Test 方法就可以，最后还是通过获取文件的绝对路径解决
 *
 * @author zc-cris
 * @version 1.0
 **/
public class DemoTest {
    public static void main(String[] args) throws FileNotFoundException {

        String property = System.getProperty("user.dir");
        System.out.println("property = " + property);
        File file = new File(property + "/demo01/1.txt");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(property + "/demo01/5.txt");
        try (inputStream; outputStream) {
            int len;
            byte[] bytes = new byte[1024];
            while ((len = (inputStream.read(bytes))) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test7() throws IOException, ClassNotFoundException {
        Person cris = new Person(23, "cris", 34.23);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"));
        objectOutputStream.writeObject(cris);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"));
        Object object = objectInputStream.readObject();
        System.out.println("object = " + object);
    }

    @Test
    public void test6() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(String.format("key:%s, value:%s", k, v)));
    }

    @Test
    public void test01() throws IOException {

        File file = new File("1.txt");
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.length() = " + file.length());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());

    }


    @Test
    public void test1() throws IOException {
        test01();

    }

    @Test
    public void test3() throws FileNotFoundException, UnsupportedEncodingException {
        test2();
    }

    @Test
    public void test() throws UnsupportedEncodingException {

    }

    @Test
    public void test2() throws FileNotFoundException, UnsupportedEncodingException {
        Reader reader = new InputStreamReader(new FileInputStream("c:/file/1.txt"), "GBK");
        Writer writer = new OutputStreamWriter(new FileOutputStream("c:/file/3.txt"), "UTF-8");
        try (reader; writer) {
            char[] chars = new char[1024];
            int len;
            while ((len = (reader.read(chars))) != -1) {
                writer.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try (BufferedReader reader = new BufferedReader(new FileReader("1.txt")); BufferedWriter writer = new BufferedWriter(new FileWriter("3.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
