package Concurrency;

public class HelloThread extends Thread{
    int id;
    public HelloThread (int i){
        this.id = i;
    }
    public void run() {
        int count = 0;
        while(count <= 20) {
            System.out.println(count++ + " T" + id);
//            if(id == 1 && count == 10) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    System.out.println("Error!");
//                }
//            }
        }
    }

    public static void main(String args[]) {
        Thread T1 = new HelloThread(1);
        Thread T2 = new HelloThread(2);
        T1.start();
        T2.start();
    }
}
