package part1.chapter17;

class StringConversions {
    public static void main(String[] args) {
        int num = 19648;
        System.out.println(num + " in Binary form: " + Integer.toBinaryString(num));
        System.out.println(num + " in Octal form: " + Integer.toOctalString(num));
        System.out.println(num + " in Hex form: " + Integer.toHexString(num));
    }
}
