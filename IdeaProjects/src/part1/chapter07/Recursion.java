package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("factorial 3: " + f.fact(3));
        System.out.println("factorial 4: " + f.fact(4));
        System.out.println("factorial 5: " + f.fact(5));
    }
}
