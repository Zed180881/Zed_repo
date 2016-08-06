package part1.chapter17;

class RTTI {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        Class<?> clObj;
        clObj = x.getClass();
        System.out.println("x is Object of Type: " + clObj.getName());
        clObj = y.getClass();
        System.out.println("y is Object of Type: " + clObj.getName());
        clObj = clObj.getSuperclass();
        System.out.println("SuperClass of y: " + clObj.getName());

    }
}
