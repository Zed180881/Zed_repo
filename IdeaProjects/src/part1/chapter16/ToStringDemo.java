package part1.chapter16;

class ToStringDemo {
    public static void main(String[] args) {
        Box b = new Box(10, 12, 14);
        String s = "Object b of Box Type: " + b;
        System.out.println(b);
        System.out.println(s);
    }

}
