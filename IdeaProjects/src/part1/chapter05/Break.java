package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class Break {
    public static void main(String[] args) {
        boolean t = true;

        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Предшествует оператору break.");
                    if (t)
                        break second;
                    System.out.println("Этот оператор не будет выполяться");
                }
                System.out.println("Этот оператор не будет выполяться");
            }
            System.out.println("Этот оператор следует за блоком second.");
        }
    }
}
