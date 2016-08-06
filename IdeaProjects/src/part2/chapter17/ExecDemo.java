package part1.chapter17;

class ExecDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("Notepad");
        } catch (Exception e) {
            System.out.println("Error launching Notepad");
        }
    }
}
