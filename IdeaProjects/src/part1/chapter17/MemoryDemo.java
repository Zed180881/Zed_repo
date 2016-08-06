package part1.chapter17;

class MemoryDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        long mem1, mem2;
        Integer[] someInts = new Integer[1000];

        System.out.println("Total memory: " + r.totalMemory());
        mem1 = r.freeMemory();
        System.out.println("Free memory at begin: " + mem1);
        r.gc();
        mem1 = r.freeMemory();
        System.out.println("Free memory after clean: " + mem1);

        for (int i = 0; i < 1000; i++) {
            someInts[i] = new Integer(i);
        }
        mem2 = r.freeMemory();
        System.out.println("Free memory after allocation: " + mem2);
        System.out.println("Use memory for allocation: " + (mem1 - mem2));

        for (int i = 0; i < 1000; i++) {
            someInts[i] = null;
        }
        r.gc();

        mem2 = r.freeMemory();
        System.out.println("Free memory after clean someInts: " + mem2);


    }
}
