package part1.chapter09;

interface IntStack {
    void push(int item);

    int pop();

    default void clear() {
//        System.out.println("Method clear() not implemented");
        throw new UnsupportedOperationException();
    }
}
