package part1.chapter08;

class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box ob) {
        this.width = ob.width;
        this.height = ob.height;
        this.depth = ob.depth;
    }

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    Box() {
        this.width = -1;
        this.height = -1;
        this.depth = -1;
    }

    Box(double len) {
        this.width = this.height = this.depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}
