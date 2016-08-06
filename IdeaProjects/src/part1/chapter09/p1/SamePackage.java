package part1.chapter09.p1;

class SamePackage {
    public SamePackage() {
        Protection p = new Protection();
        System.out.println("Same package class constructor");
        System.out.println("n = " + p.n);
//        System.out.println("nPri = " + p.nPri);
        System.out.println("nPro = " + p.nPro);
        System.out.println("nPub = " + p.nPub);
    }
}
