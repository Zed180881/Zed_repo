package part1.chapter08;

import java.lang.*;
import java.lang.Override;

class Rectangle extends Figure {

    Rectangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("In rectangle.");
        return dim1 * dim2;
    }
}
