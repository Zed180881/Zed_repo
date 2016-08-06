package part1.chapter12;

enum Apple1 {
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price;

    Apple1(int price) {
        this.price = price;
    }

    Apple1() {
        this.price = -1;
    }

    int getPrice() {
        return price;
    }
}
