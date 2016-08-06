package part1.chapter12;

class EnumDemo3 {
    public static void main(String[] args) {
        Apple1 ap;

        System.out.println("Apple of Winesap costs " + Apple1.Winesap.getPrice() + " cents");

        System.out.println("All apples prices:");
        for (Apple1 a : Apple1.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents");
        }
    }
}
