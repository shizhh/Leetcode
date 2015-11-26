package algorithm;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MyThread {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int index = 0; index < 50; index++) {
            Runnable run = new Runner(index);
            exec.execute(run);
        }
//        exec.shutdown();
    }
}

class Runner implements Runnable {
    int index;

    public Runner(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        long time = (long) (Math.random() * 1000);
        System.out.println("线程：" + Thread.currentThread().getName() + "(目标对象" + index + ")" + ":Sleeping" + time + "ms");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
}
