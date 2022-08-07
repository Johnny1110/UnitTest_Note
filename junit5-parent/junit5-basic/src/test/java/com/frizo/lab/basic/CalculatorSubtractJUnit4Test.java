package com.frizo.lab.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals; // JUnit4 API

public class CalculatorSubtractJUnit4Test {

    @Test
    public void subtractNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(3, 1));
    }
}
