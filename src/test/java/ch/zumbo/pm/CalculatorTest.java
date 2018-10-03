package ch.zumbo.pm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.params.provider.Arguments.*;

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
