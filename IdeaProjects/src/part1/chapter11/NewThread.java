package part1.chapter11;

class NewThread implements Runnable {
    Thread t;

    public NewThread() {
        this.t = new Thread(this, "Demo thread");
        System.out.println("Child thread created: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread interrupted");
        }
        System.out.println("Child thread finished");
    }
}
