package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class OverloadCons {
    public static void main(String[] args) {
        Box myBox1 = new Box(10, 20, 15);
        Box myBox2 = new Box();
        Box myCube = new Box(7);

        Box myClone = new Box(myBox1);

        System.out.println("myBox1 volume: " + myBox1.volume());
        System.out.println("myBox2 volume: " + myBox2.volume());
        System.out.println("myCube volume: " + myCube.volume());
        System.out.println("myClone volume: " + myClone.volume());
    }
}
