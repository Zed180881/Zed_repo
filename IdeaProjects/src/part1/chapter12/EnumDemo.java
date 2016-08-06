package part1.chapter12;

class EnumDemo {
    public static void main(String[] args) {
        Apple apple;

        apple = Apple.RedDel;
        System.out.println("Apple value: " + apple);
        System.out.println();

        apple = Apple.GoldenDel;

        if (apple == Apple.GoldenDel)
            System.out.println("apple value is GoldenDel");

        switch (apple) {
            case Jonathan:
                System.out.println("Jonathan is red");
                break;
            case GoldenDel:
                System.out.println("GoldenDel is yellow");
                break;
            case RedDel:
                System.out.println("RedDel is red");
                break;
            case Winesap:
                System.out.println("Winesap is red");
                break;
            case Cortland:
                System.out.println("Cortland is red");
                break;
        }
    }
}
