package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class CommandLine {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}
