package part1.chapter15;

class VarCapture {
    public static void main(String[] args) {
        int num = 10;
        MyFunc myLambda = (n) -> {
            int v = num + n;
//            num++;
            return v;
        };
//        num = 9;
    }
}
