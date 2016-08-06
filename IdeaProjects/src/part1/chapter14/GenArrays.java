package part1.chapter14;

class GenArrays {
    public static void main(String[] args) {
        Integer[] n = {1, 2, 3, 4, 5};
        Gen5<Integer> iOb = new Gen5<>(50, n);

//        Gen5<Integer> gens = new Gen5<>()[10];

        Gen5<?>[] gens = new Gen5<?>[10];
    }
}
