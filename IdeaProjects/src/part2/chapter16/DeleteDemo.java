package part1.chapter16;

class DeleteDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This is simple test.");
        sb.delete(3, 11);
        System.out.println("After call delete(): " + sb);
        sb.deleteCharAt(0);
        System.out.println("After call deleteCharAt(): " + sb);

    }
}
