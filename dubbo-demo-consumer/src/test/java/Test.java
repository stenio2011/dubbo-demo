import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by stenio on 2017/9/13.
 */
public class Test {
    int i;

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (test) {
                        test.i++;
                        test.notify();
                        if (test.i % 2 == 0) {
                            System.out.println("thread-1--" + test.i);
                            try {
                                test.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        }, "thread-1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (test) {
                        test.i++;
                        test.notify();
                        if (test.i % 2 == 1) {
                            System.out.println("thread-2--" + test.i);
                            try {
                                test.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        }, "thread-2");
        test.executorService.submit(t1);
        test.executorService.submit(t2);
    }

}
