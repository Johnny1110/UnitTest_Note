package com.frizo.lab.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSubtractTest {

    @Test
    public void subtractNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(3, 1));
    }
}
