package part1.chapter10;

class ChainExcdemo {
    static void demoproc() {
        NullPointerException e = new NullPointerException("upper level");
        e.initCause(new ArithmeticException("exception cause"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Exception catched " + e);
            System.out.println("Exception cause " + e.getCause());
        }
    }
}
