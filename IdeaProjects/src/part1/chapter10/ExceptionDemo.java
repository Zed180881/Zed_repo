package part1.chapter10;

class ExceptionDemo {
    static void compute(int a) throws MyException {
        System.out.println("Called method compute(" + a + ")");
        if (a > 10)
            throw new MyException(a);
        System.out.println("Normal ending");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Exception catched: " + e);
        }
    }
}
