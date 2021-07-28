package com.woodlight.math;

public class Calculate {
    public Operators operation;

    public Calculate() {
        long long1 = 0;
        long long2 = 0;

        double result = 0;

        operation = Operators.blank;

        if (operation == Operators.plus) {
            result = long1 + long2;
        }
        if (operation == Operators.minus) {
            result = long1 - long2;
        }
        if (operation == Operators.multiply) {
            result = long1 * long2;
        }
        if (operation == Operators.divide) {
            result = long1 / long2;
        }
        if (operation == Operators.fraction) {
            result = -1;
        }

    }
}
