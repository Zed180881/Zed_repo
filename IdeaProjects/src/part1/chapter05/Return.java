package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class Return {
    public static void main(String[] args) {
        boolean t = true;
        System.out.println("До возврата.");
        if (t)
            return;
        System.out.println("Этот оператор вызываться не будет");
    }
}
