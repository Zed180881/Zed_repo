package part1.chapter19;

class ObserverDemo {
    public static void main(String[] args) {
        BeingWatched observed = new BeingWatched();
        Watcher observing = new Watcher();

        observed.addObserver(observing);
        observed.counter(10);
    }
}
