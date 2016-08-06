package part1.chapter16;

class Box {
    double width;
    double height;
    double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Размеры " + width +
                " на " + height +
                " на " + depth +
                '.';
    }
}
