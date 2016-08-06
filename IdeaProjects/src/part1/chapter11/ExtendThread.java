package part1.chapter11;

class ExtendThread {
    public static void main(String[] args) {
        new NewThread1();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }
        System.out.println("Main thread finished");
    }
}
