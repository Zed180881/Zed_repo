package part1.chapter09;

class Client implements Callback {
    @Override
    public void callback(int param) {
        System.out.println("Method callback(), called with value " + param);
    }

    void nonInterfaceMeth() {
        System.out.println("Non-interface method");
    }
}
