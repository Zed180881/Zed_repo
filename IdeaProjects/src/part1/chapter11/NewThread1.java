package part1.chapter11;

class NewThread1 extends Thread {

    NewThread1() {
        super("Demo Thread");
        System.out.println("Child Thread: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread was interrupted");
        }
        System.out.println("Child thread finished");
    }
}
