package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class NoBody {
    public static void main(String[] args) {
        int i, j;
        i = 100;
        j = 200;
        while (++i < --j) ;

        System.out.println("Среднее значение равно " + i);
    }
}
