package part1.chapter19;

class TwoObservers {
    public static void main(String[] args) {
        BeingWatched observed = new BeingWatched();
        Watcher observing1 = new Watcher();
        Watcher2 observing2 = new Watcher2();

        observed.addObserver(observing1);
        observed.addObserver(observing2);
        observed.counter(10);
    }
}
