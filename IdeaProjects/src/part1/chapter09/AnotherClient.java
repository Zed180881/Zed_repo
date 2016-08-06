package part1.chapter09;

class AnotherClient implements Callback {
    @Override
    public void callback(int param) {
        System.out.println("Another variant of callback method");
        System.out.println("p*p = " + (param * param));
    }
}
