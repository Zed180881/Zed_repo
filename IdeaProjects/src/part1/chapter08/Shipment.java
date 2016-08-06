package part1.chapter08;

class Shipment extends BoxWeight {
    double cost;

    Shipment(Shipment ob) {
        super(ob);
        this.cost = ob.cost;
    }

    Shipment(double width, double height, double depth, double weight, double cost) {
        super(width, height, depth, weight);
        this.cost = cost;
    }

    Shipment() {
        this.cost = -1;
    }

    Shipment(double len, double weight, double cost) {
        super(len, weight);
        this.cost = cost;
    }
}
