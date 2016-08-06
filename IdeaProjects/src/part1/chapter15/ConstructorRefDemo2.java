package part1.chapter15;

class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc4<Integer> myClassCons = MyClass1<Integer>::new;

        MyClass1<Integer> mc = myClassCons.func(100);

        System.out.println("Value of val in ibject mc: " + mc.getVal());
    }
}
