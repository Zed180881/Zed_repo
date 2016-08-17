package part2.chapter28;

class AtomThread implements Runnable {
    String name;

    AtomThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Launch thread " + name);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread " + name + " get: " + SharedAtomic.ai.getAndSet(i));
        }
    }
}
