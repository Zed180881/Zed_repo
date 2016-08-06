package part1.chapter15;

class MethodRefDemo2 {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }


    public static void main(String[] args) {
        String inStr = "Lambda-Expressions improve Java efficiency";
        MyStringOps1 strOps = new MyStringOps1();
        String outStr = stringOp(strOps::strReverse, inStr);
        System.out.println("Source String: " + inStr);
        System.out.println("Reverse String: " + outStr);
    }
}
