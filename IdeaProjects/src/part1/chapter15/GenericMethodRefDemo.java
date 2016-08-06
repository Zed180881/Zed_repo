package part1.chapter15;

class GenericMethodRefDemo {
    static <T> int myOp(MyFunc2<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};

        int count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        System.out.println("vals contais " + count + " examples of 4");

        count = myOp(MyArrayOps::<String>countMatching, strs, "Two");
        System.out.println("strs contais " + count + " examples of Two");

    }
}
