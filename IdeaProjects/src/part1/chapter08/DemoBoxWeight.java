package part1.chapter08;

class DemoBoxWeight {
    public static void main(String[] args) {
        BoxWeight myBox1 = new BoxWeight(10, 20, 15, 34.3);
        BoxWeight myBox2 = new BoxWeight(2, 3, 4, 0.076);

        System.out.println("Volume of myBox1: " + myBox1.volume());
        System.out.println("Weight of myBox1: " + myBox1.weight);
        System.out.println();

        System.out.println("Volume of myBox2: " + myBox2.volume());
        System.out.println("Weight of myBox2: " + myBox2.weight);
        System.out.println();
    }
}
