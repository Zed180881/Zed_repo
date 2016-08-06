package part1.chapter10;

class ThrowsDemo {
    static void throwOne() throws IllegalAccessException {
        System.out.println("In method throwOne()");
        throw new IllegalAccessException("demonstration");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Exception catched: " + e);
        }
    }
}
