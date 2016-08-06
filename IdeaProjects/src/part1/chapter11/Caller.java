package part1.chapter11;

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(String msg, CallMe target) {
        this.msg = msg;
        this.target = target;
        this.t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
