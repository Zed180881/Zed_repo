package part1.chapter14;

interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}
