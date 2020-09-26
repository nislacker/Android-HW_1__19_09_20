package com.demo.hw_1__19_09_20;

public class SquareEquasion {

    private double a, b, c;

    public SquareEquasion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double[] getRoots() {
        Double D = b*b - 4*a*c;
        if (D >= 0) {
            Double x1 = (-b + Math.sqrt(D))/(2*a);
            Double x2 = (-b - Math.sqrt(D))/(2*a);
            return new Double[] {x1, x2};
        }

        return new Double[] {null, null};
    }
}
