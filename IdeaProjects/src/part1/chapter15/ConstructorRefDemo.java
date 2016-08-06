package part1.chapter15;

class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc3 myClassCons = MyClass::new;

        MyClass mc = myClassCons.func(100);

        System.out.println("Value of val in ibject mc: " + mc.getVal());
    }
}
