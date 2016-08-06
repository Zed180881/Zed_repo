package part1.chapter11;

class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller("Welcome", target);
        Caller ob2 = new Caller("to the synchronized", target);
        Caller ob3 = new Caller("world!", target);
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
