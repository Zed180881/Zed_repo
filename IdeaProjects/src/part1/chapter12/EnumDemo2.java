package part1.chapter12;

class EnumDemo2 {
    public static void main(String[] args) {
        Apple apple;
        System.out.println("Constants of enum type Apple:");

        Apple[] apples = Apple.values();
        for (Apple a : apples) {
            System.out.println(a);
        }
        System.out.println();

        apple = Apple.valueOf("Winesap");
        System.out.println("Var apple contains " + apple);
    }
}
