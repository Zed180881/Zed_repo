package part1.chapter17;

class ExecDemoFini {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("Notepad");
            p.waitFor();
        } catch (Exception e) {
            System.out.println("Error launching Notepad");
        }
        System.out.println("Notepad return " + p.exitValue());
    }
}
