package part1.chapter09;

class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIfImpl obj = new MyIfImpl();
        System.out.println(obj.getNumber());
        System.out.println(obj.getString());

        MyIfImpl2 obj2 = new MyIfImpl2();
        System.out.println(obj2.getNumber());
        System.out.println(obj2.getString());

        System.out.println(MyIf.getDefaultNumber());
    }
}
