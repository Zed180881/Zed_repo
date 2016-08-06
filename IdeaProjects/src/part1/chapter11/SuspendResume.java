package part1.chapter11;

class SuspendResume {
    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("One");
        NewThread4 ob2 = new NewThread4("Two");
        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspend thread one");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resume thread one");
            ob2.mySuspend();
            System.out.println("Suspend thread two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resume thread two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        try {
            System.out.println("Waiting for threads finish");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread finished");
    }
}
