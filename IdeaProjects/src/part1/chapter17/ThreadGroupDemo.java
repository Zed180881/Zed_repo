package part1.chapter17;

class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        NewThread ob1 = new NewThread("One", groupA);
        NewThread ob2 = new NewThread("Two", groupA);
        NewThread ob3 = new NewThread("Three", groupB);
        NewThread ob4 = new NewThread("Four", groupB);

        System.out.println("Method list() out:");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Group A suspending");
        Thread[] tga = new Thread[groupA.activeCount()];
        groupA.enumerate(tga);
        for (int i = 0; i < tga.length; i++) {
            ((NewThread) tga[i]).mySuspend();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Continue of Group A");
        for (int i = 0; i < tga.length; i++) {
            ((NewThread) tga[i]).myResume();
        }
        try {
            System.out.println("Waiting for Threads finish.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (Exception e) {
            System.out.println("Exception in main thread");
        }
        System.out.println("Main thread finished");
    }
}
