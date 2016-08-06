package part1.chapter17;

class Elapsed {
    public static void main(String[] args) {
        long start, end;
        System.out.println("Measuring count to 100000000 time");
//        start = System.currentTimeMillis();
        start = System.nanoTime();
        for (long i = 0; i < 10000000L; i++) ;
//        end = System.currentTimeMillis();
        end = System.nanoTime();
        System.out.println("Execution time: " + (end - start));
    }
}
