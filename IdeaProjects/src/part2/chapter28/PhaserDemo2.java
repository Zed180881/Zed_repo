package part2.chapter28;


class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phsr = new MyPhaser(1, 4);

        System.out.println("Threads launch");
        new MyThreadPhaser2(phsr, "A");
        new MyThreadPhaser2(phsr, "B");
        new MyThreadPhaser2(phsr, "C");

        while (!phsr.isTerminated())
            phsr.arriveAndAwaitAdvance();

        System.out.println("Phaser ended");
    }
}
