package day16;

import org.junit.*;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class JunitTest {

    @Test
    public void test1(){
        System.out.println("test1....." );
    }

    @Test
    public void test4(){
        System.out.println("test4" );
    }

    @Before
    public void test2(){
        System.out.println("before" );
    }
    
    @After
    public void test3(){
        System.out.println("end...." );
    }
    
    @BeforeClass
    public static void testInit(){
        System.out.println("init...." );
    }

    @AfterClass
    public static void testDestroy(){
        System.out.println("destroy---" );
    }

    @Ignore
    public void testIgnore(){
        System.out.println("未完成。。。" );
    }
}
