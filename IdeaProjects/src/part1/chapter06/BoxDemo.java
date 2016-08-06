package part1.chapter06;

/**
 * Created by Zed on 14.07.2016.
 */
class BoxDemo {
    public static void main(String[] args) {

        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box(3, 6, 9);

        System.out.println("Обьем равен " + myBox1.volume());
        System.out.println("Обьем равен " + myBox2.volume());
    }
}