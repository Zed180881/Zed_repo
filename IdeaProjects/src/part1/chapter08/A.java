package part1.chapter08;

class A {
    int i, j;

    A() {
    }

    A(int i, int j) {
        this.i = i;
        this.j = j;
    }

    void showIJ() {
        System.out.println("i and j: " + i + " " + j);
    }

    void show() {
        System.out.println("i and j: " + i + " " + j);
    }

    void callMe(){
        System.out.println("In method callMe of class A");
    }
}
