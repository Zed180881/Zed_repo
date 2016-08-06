package part1.chapter12;

class EnumDemo4 {
    public static void main(String[] args) {
        Apple ap1, ap2, ap3;

        System.out.println("all apple consts " +
                "and their ordinals");
        for (Apple apple : Apple.values()) {
            System.out.println(apple + " " + apple.ordinal());
        }

        ap1 = Apple.RedDel;
        ap2 = Apple.GoldenDel;
        ap3 = Apple.RedDel;

        System.out.println();

        if (ap1.compareTo(ap2) < 0)
            System.out.println(ap1 + " is before " + ap2);
        if (ap1.compareTo(ap2) > 0)
            System.out.println(ap2 + " is before " + ap1);
        if (ap1.compareTo(ap3) == 0)
            System.out.println(ap1 + " is equal " + ap3);

        System.out.println();

        if (ap1.equals(ap2))
            System.out.println("Error!");
        if (ap1.equals(ap3))
            System.out.println(ap1 + " equals " + ap3);
        if (ap1 == ap3)
            System.out.println(ap1 + " == " + ap3);
    }
}
