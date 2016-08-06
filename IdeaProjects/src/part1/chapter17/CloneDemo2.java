package part1.chapter17;

class CloneDemo2 {
    public static void main(String[] args) {
        TestClone2 x1 = new TestClone2();
        TestClone2 x2;

        x1.a = 10;
        x1.b = 20.98;

        x2 = (TestClone2) x1.clone();

        System.out.println("x1: " + x1.a + " " + x1.b);
        System.out.println("x2: " + x2.a + " " + x2.b);
    }
}
