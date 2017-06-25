package com.learning.tdd.fibonacci;

class Fibonacci {

    private int zeroth = 0;
    private int first = 1;

    int getElement(int index) {
        if (index == 0) {
            return zeroth;
        } else if (index == 1) {
            return first;
        } else {
            return getElement(index - 1) + getElement(index - 2);
        }
    }
}
