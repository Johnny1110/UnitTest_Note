package com.frizo.lab.basic;

import org.junit.Test; // JUnit4 API

import static org.junit.Assert.assertEquals; // JUnit4 API

public class CalculatorAddJUnit4Test {

    @Test
    public void addTwoNumber() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

}
