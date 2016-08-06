package part1.chapter20;

class PrintfDemo {
    public static void main(String[] args) {
        System.out.println("Numbers in different formats: ");
        System.out.printf("Different integer formats:");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();

        System.out.printf("Double format by default: %f\n", 1234567.123);
        System.out.printf("Double format with comma: %,f\n", 1234567.123);
        System.out.printf("Negative double format by default: %,f\n", -1234567.123);
        System.out.printf("Another negative double format: %,(f\n", -1234567.123);
        System.out.println();

        System.out.printf("Alignment of positive and negative numbers:\n");
        System.out.printf("% ,.2f\n% ,2f\n", 1234567.123, -1234567.123);
    }
}
