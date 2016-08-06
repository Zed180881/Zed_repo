package part1.chapter16;

class ReplaceDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This is simple test.");
        sb.replace(5, 7, "was");
        System.out.println("After replacement: " + sb);
    }
}
