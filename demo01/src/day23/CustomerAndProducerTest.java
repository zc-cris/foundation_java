package day23;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class CustomerAndProducerTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        new Thread(() ->{
            for (int i = 0; i < 2; i++) {
                factory.increase();
            }
        }).start();
        new Thread(() ->{
            for (int i = 0; i < 2; i++) {
                factory.increase();
            }
        }).start();
        new Thread(() ->{
            for (int i = 0; i < 2; i++) {
                factory.decrease();
            }
        }).start();
        new Thread(() ->{
            for (int i = 0; i < 2; i++) {
                factory.decrease();
            }
        }).start();

    }

}

@SuppressWarnings("unused")
class Factory {
    private int product;

    public void increase() {
        synchronized (this) {
            while (product != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (product < 3) {
                System.out.println("product = " + (++product));
            }
            notifyAll();
        }
    }

    public void decrease() {
        synchronized (this) {
            while (product == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (product > 0) {
                System.out.println("product = " + (product--));
            }
            notifyAll();
        }
    }
}

