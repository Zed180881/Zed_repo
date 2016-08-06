package part1.chapter11;

class DeadLock implements Runnable {

    A a = new A();
    B b = new B();

    DeadLock() {
        Thread.currentThread().setName("Main Thread");
        Thread t = new Thread(this, "Concurrent thread");
        t.start();
        a.foo(b);
        System.out.println("Back to main thread");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Back to second thread");
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}
