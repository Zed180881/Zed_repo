package part1.chapter08;

class RefDemo {
    public static void main(String[] args) {
        BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
        Box plainBox = new Box();
        double volume = weightBox.volume();

        System.out.println("Volume of weightBox: " + volume);
        System.out.println("Weight of weightBox: " + weightBox.weight);
        System.out.println();

        plainBox = weightBox;
        volume = plainBox.volume();
        System.out.println("Volume of plainBox: " + volume);
//        System.out.println(plainBox.weight);
    }
}
