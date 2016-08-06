package part1.chapter15;

class ConstructorRefDemo3 {

    static <R, T> R myClassFactory(MyFunc5<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc5<MyClass1<Double>, Double> myClassCons = MyClass1<Double>::new;

        MyClass1<Double> mc = myClassFactory(myClassCons, 100.1);

        System.out.println("Value of val in ibject mc: " + mc.getVal());

        MyFunc5<MyClass2, String> myClassCons2 = MyClass2::new;
        MyClass2 mc2 = myClassFactory(myClassCons2, "Lambda");
        System.out.println("Value of val in ibject mc2: " + mc2.getVal());

    }
}
