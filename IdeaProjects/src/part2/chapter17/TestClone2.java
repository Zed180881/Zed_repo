package part1.chapter17;

class TestClone2 implements Cloneable {
    int a;
    double b;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning impossible");
            return this;
        }
    }
}
