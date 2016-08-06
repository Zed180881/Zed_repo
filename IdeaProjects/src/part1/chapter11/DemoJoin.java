package part1.chapter11;

class DemoJoin {
    public static void main(String[] args) {
        NewThread3 ob1 = new NewThread3("One");
        NewThread3 ob2 = new NewThread3("Two");
        NewThread3 ob3 = new NewThread3("Three");

        System.out.println("Thread one started: " + ob1.t.isAlive());
        System.out.println("Thread two started: " + ob2.t.isAlive());
        System.out.println("Thread three started: " + ob3.t.isAlive());

        try {
            System.out.println("Wait for threads finished");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Thread one started: " + ob1.t.isAlive());
        System.out.println("Thread two started: " + ob2.t.isAlive());
        System.out.println("Thread three started: " + ob3.t.isAlive());

        System.out.println("Main thread finished");
    }
}
