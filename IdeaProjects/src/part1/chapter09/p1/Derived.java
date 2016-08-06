package part1.chapter09.p1;

class Derived extends Protection {
    Derived() {
        System.out.println("Sub class constructor");
        System.out.println("n = " + n);
//        System.out.println("nPri = " + nPri);
        System.out.println("nPro = " + nPro);
        System.out.println("nPub = " + nPub);
    }
}
