package part1.chapter14;

class GenCons {
    private double val;

    <T extends Number> GenCons(T val) {
        this.val = val.doubleValue();
    }

    void showVal() {
        System.out.println("val: " + val);
    }
}
