package part1.chapter09.p2;

import part1.chapter09.p1.Protection;

class OtherPackage {
    public OtherPackage() {
        Protection p = new Protection();
        System.out.println("Other package class constructor");
//        System.out.println("n = " + p.n);
//        System.out.println("nPri = " + p.nPri);
//        System.out.println("nPro = " + p.nPro);
        System.out.println("nPub = " + p.nPub);
    }
}
