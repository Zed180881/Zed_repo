package part1.chapter16;

class IndexOfDemo1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("one two one");
        int i;

        i = sb.indexOf("one");
        System.out.println("indexOf: " + i);

        i = sb.lastIndexOf("one");
        System.out.println("lastIndexOf: " + i);
    }
}
