package part1.chapter09.p2;

import part1.chapter09.p1.Protection;

class Protection2 extends Protection{
    public Protection2() {
        System.out.println("Derived from other package class constructor");
//        System.out.println("n = " + n);
//        System.out.println("nPri = " + nPri);
        System.out.println("nPro = " + nPro);
        System.out.println("nPub = " + nPub);
    }
}
