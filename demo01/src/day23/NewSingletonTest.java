package day23;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class NewSingletonTest {
    public static void main(String[] args) {
        Instant now = Instant.now();
        NewSingleton instance = NewSingleton.getInstance();
        NewSingleton instance1 = NewSingleton.getInstance();
        System.out.println("(instance1 == instance) = " + (instance1 == instance));
        Instant now1 = Instant.now();
        // Duration.between(now,now1) = 30
        System.out.println("Duration.between(now,now1) = " + Duration.between(now, now1).toMillis());

        Instant now2 = Instant.now();
        NewSingleton2 newSingleton2 = NewSingleton2.getInstance();
        NewSingleton2 newSingleton3 = NewSingleton2.getInstance();
        System.out.println("(newSingleton3 == newSingleton2) = " + (newSingleton3 == newSingleton2));
        Instant now3 = Instant.now();
        // Duration.between(now2,now3) = 0
        System.out.println("Duration.between(now2,now3) = " + Duration.between(now2, now3).toMillis());


//        Duration.between(now4,now5).toMillis() = 0
        Instant now4 = Instant.now();
        Singleton3 instance2 = Singleton3.getInstance();
        Singleton3 instance3 = Singleton3.getInstance();
        System.out.println("(instance3==instance2) = " + (instance3 == instance2));
        Instant now5 = Instant.now();
        System.out.println("Duration.between(now4,now5).toMillis() = " + Duration.between(now4, now5).toMillis());
    }
}

class NewSingleton {
    private static NewSingleton INSTANCE;
    private static Lock lock = new ReentrantLock();

    private NewSingleton() {
    }

    public static NewSingleton getInstance() {
        if (INSTANCE == null) {
            try {
                lock.lock();
                if (INSTANCE == null) {
                    INSTANCE = new NewSingleton();
                }
            } finally {
                lock.unlock();
            }
        }
        return INSTANCE;
    }
}

class NewSingleton2 {
    private static NewSingleton2 Instance;

    private NewSingleton2() {
    }

    public static NewSingleton2 getInstance() {
        if (Instance == null) {
            synchronized (NewSingleton2.class) {
                if (Instance == null) {
                    Instance = new NewSingleton2();
                }
            }
        }
        return Instance;
    }
}

class Singleton3 {

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return Singleton3Instance.INSTANCE;
    }

    private static class Singleton3Instance {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
}
