package part1.chapter15;

class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }


    public static void main(String[] args) {
        String inStr = "Lambda-Expressions improve Java efficiency";
        String outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Source String: " + inStr);
        System.out.println("Reverse String: " + outStr);
    }
}
