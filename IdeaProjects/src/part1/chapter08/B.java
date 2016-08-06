package part1.chapter08;

import java.lang.*;
import java.lang.Override;

class B extends A {
    int k;

    B(){

    }

    B(int i, int j, int k) {
        super(i, j);
        this.k = k;
    }

    void showK() {
        System.out.println("k: " + k);
    }

    @Override
    void show() {
        super.show();
        System.out.println("k: " + k);
    }

    void sum() {
        System.out.println("i+j+k: " + (i + j + k));
    }

    @Override
    void callMe() {
        System.out.println("In method callMe of class B");
    }
}
