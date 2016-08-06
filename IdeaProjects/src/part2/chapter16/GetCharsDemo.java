package part1.chapter16;

class GetCharsDemo {
    public static void main(String[] args) {
        String s = "This is demo of getChars() method.";
        int start = 8;
        int end = 12;
        char[] buf = new char[end - start];
        s.getChars(start, end, buf, 0);
        System.out.println(buf);
    }
}
