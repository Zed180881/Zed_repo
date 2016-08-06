package part1.chapter08;

import java.lang.*;
import java.lang.Override;

class Triangle extends Figure {

    Triangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("In triangle.");
        return dim1 * dim2 / 2;
    }
}
