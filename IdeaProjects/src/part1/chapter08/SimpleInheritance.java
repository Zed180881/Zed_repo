package part1.chapter08;

class SimpleInheritance {
    public static void main(String[] args) {
        A superOb = new A(1, 2);
        B subOb = new B(1, 2, 3);

        superOb.i = 10;
        superOb.j = 20;
        System.out.println("Contents of superObject: ");
        superOb.showIJ();
        System.out.println();

        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;
        System.out.println("Contents of subObject: ");
        subOb.showIJ();
        subOb.showK();
        System.out.println();
        System.out.println("Sum i, j, k in subObject:");
        subOb.sum();
    }
}
