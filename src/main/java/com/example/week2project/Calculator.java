package com.example.week2project;

public class Calculator {
    public float operator(float a, float b, String op) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        if (op.equals("/")) {
            return a / b;
        }
        if (op.equals("*")) {
            return a * b;
        }
        return 0;
    }

    public boolean isNum(String s) {
        try {
            float f = Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
