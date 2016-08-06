package part1.chapter11;

class PC {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("For stop press CTRL+C");
    }
}
