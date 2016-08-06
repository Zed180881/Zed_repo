package part1.chapter03;

/**
 * Created by Zed on 13.07.2016.1
 */
class BoolTest {

    public static void main(String[] args) {
        boolean b = false;
        System.out.println("b равно " + b);
        b = true;
        System.out.println("b равно " + b);

        if (b)
            System.out.println("Этот код выполняется.");
        b = false;
        if (b)
            System.out.println("Этот код не выполняетсяю");

        System.out.println("10 > 9 равно " + (10 > 9));
    }


}
