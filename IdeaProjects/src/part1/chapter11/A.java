package part1.chapter11;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter method A.foo()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Class A interrupted");
        }
        System.out.println(name + " try to call method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("In method A.last()");
    }
}
