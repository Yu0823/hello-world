package Algorithm;

import java.util.*;

public class Test extends Thread{
    private static int count = 0;
//    private static byte[] b = new byte[0];
    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Test());
            thread1.start();
        }
         main.sleep(1000);
        System.out.println(count);
        HashSet set = new HashSet<Integer>();
        Queue q = new LinkedList();
        List l = new ArrayList();
        String s;
        HashMap m = new HashMap<Integer, Integer>();
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) count++;
            System.out.println(Thread.currentThread().getName()+": "+count);
        }
    }


}
