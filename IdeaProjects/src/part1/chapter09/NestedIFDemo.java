package part1.chapter09;

class NestedIFDemo {
    public static void main(String[] args) {
        A.NestedIF nif = new B();
        if (nif.isNotNegative(10))
            System.out.println("number is not negative");
        if (nif.isNotNegative(-12))
            System.out.println("this will not be shown");
    }
}
