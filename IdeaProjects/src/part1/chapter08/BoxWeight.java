package part1.chapter08;

class BoxWeight extends Box {
    double weight;

    BoxWeight(BoxWeight ob) {
        super(ob);
        this.weight = ob.weight;
    }

    BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        this.weight = weight;
    }

    BoxWeight() {
        this.weight = -1;
    }

    BoxWeight(double len, double weight) {
        super(len);
        this.weight = weight;
    }
}
