package org.example;

import junit.framework.TestCase;
import org.example.Calculator;
import org.example.FORMAT;

public class CalculatorTest extends TestCase {

    public void testTestToString() {
        assertEquals("9", new Calculator(9, FORMAT.DECIMAL).toString());

        assertEquals("0x10a", new Calculator(0x10a, FORMAT.HEX).toString());

        assertEquals("0b1010101", new Calculator(0b1010101, FORMAT.BINARY).toString());
    }

    // ToDo add the rests of the tests
    public void testAdd() {
    }

    public void testAddAll() {
    }

    public void testMult() {
    }

    public void testDivide() {
    }

    public void testMax() {
    }

    public void testMin() {
    }
}