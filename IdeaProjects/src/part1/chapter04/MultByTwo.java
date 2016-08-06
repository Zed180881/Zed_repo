package part1.chapter04;

/**
 * Created by Zed on 13.07.2016.
 */
class MultByTwo {
    public static void main(String[] args) {

        int num = 0xFFFFFFE;
        for (int i = 0; i < 4; i++) {
            num = num << 1;
            System.out.println(num);
        }
    }
}
