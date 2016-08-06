package part1.chapter13;

class InstanceOf {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        if (a instanceof A)
            System.out.println("a is instance of A");
        if (b instanceof B)
            System.out.println("b is instance of B");
        if (c instanceof C)
            System.out.println("c is instance of C");
        if (c instanceof A)
            System.out.println("c can be casted to A");
        if (a instanceof C)
            System.out.println("a can be casted to C");
        System.out.println();

        A ob;

        ob = d;
        System.out.println("ob now pointed at d");
        if (ob instanceof D)
            System.out.println("ob is instance of D");
        System.out.println();

        ob = c;
        System.out.println("ob now pointed at c");
        if (ob instanceof D)
            System.out.println("ob can be casted to D");
        else
            System.out.println("ob can not be casted to D");
        if (ob instanceof A)
            System.out.println("ob can be casted to A");
        System.out.println();

        if (a instanceof Object)
            System.out.println("a can be casted to Object");
        if (b instanceof Object)
            System.out.println("b can be casted to Object");
        if (c instanceof Object)
            System.out.println("c can be casted to Object");
        if (d instanceof Object)
            System.out.println("d can be casted to Object");
    }
}
