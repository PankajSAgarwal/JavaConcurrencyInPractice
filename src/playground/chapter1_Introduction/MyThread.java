package playground.chapter1_Introduction;

public class MyThread extends Thread {

    @Override
    public void run(){
        // your concurrent task goes here
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
