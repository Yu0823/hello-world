package Concurrency;

public class HelloRunnable implements Runnable{
    int id;
    public HelloRunnable(int i){
        this.id = i;
    }
    public void run() {
        int count = 0;
        while(count <= 20) {
            System.out.println(count++ + " T" + id);
            if (id == 1 && count == 10) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Error!");
                }
                Thread.interrupted();
            }
        }
}

    public static void main(String[] args) {
        Thread T1 = new Thread(new HelloRunnable(1));
        Thread T2 = new Thread(new HelloRunnable(2));
        T1.start();
        T2.start();
    }
}
