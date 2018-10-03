package ch.zumbo.pm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(2f, calculator.add(1.0f, 1.0f));
    }

    @Test
    void testAdd2() {
        assertEquals(0.2f, calculator.add(0.1f, 0.1f));
    }


}
