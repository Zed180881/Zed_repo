package part1.chapter17;

class NewThread extends Thread {
    boolean suspendFlag;

    NewThread(String name, ThreadGroup group) {
        super(group, name);
        System.out.println("New Thread: " + this);
        suspendFlag = false;
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " finished.");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}
