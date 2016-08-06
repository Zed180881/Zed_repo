package part1.chapter10;

class Exc2 {
    public static void main(String[] args) {
        int d, a;
        try {
            d = 0;
            a = 42 / d;
            System.out.println("never shown");
        } catch (ArithmeticException e) {
            System.out.println("Div by Zero");
        }
        System.out.println("After catch operator");
    }
}
