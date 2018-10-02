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

    @Test
    void testAdd3() {
        assertEquals(1.111f, calculator.add(1f, 0.111f));
    }


    @ParameterizedTest
    @MethodSource("floatProvider")
    void testParametrizedAdd(float x, float y, float z) {
        assertEquals(z, calculator.add(x, y));
    }

    private static Stream<Arguments> floatProvider() {
        List<Arguments> argList = new ArrayList<>();
        BigDecimal limit = new BigDecimal("1");
        BigDecimal step = new BigDecimal("0.1");
        for (BigDecimal i = BigDecimal.ZERO; i.compareTo(limit) < 0; i = i.add(step)) {
            for (BigDecimal j = BigDecimal.ZERO; j.compareTo(limit) < 0; j = j.add(step)) {
                float arg1 = i.floatValue();
                float arg2 = j.floatValue();
                float sum = (i.add(j)).floatValue();
                argList.add(arguments(arg1, arg2, sum));
            }
        }
        return argList.stream();
    }

    @TestFactory
    List<DynamicTest> testDynamicAdd() {
        List<DynamicTest> tests = new ArrayList<>();
        BigDecimal limit = new BigDecimal("1");
        BigDecimal step = new BigDecimal("0.1");
        for (BigDecimal i = BigDecimal.ZERO; i.compareTo(limit) < 0; i = i.add(step)) {
            for (BigDecimal j = BigDecimal.ZERO; j.compareTo(limit) < 0; j = j.add(step)) {
                float arg1 = i.floatValue();
                float arg2 = j.floatValue();
                float sum = (i.add(j)).floatValue();
                tests.add(dynamicTest(arg1 + " + " + arg2,
                        () -> assertEquals(sum, calculator.add(arg1, arg2))));
            }
        }
        return tests;
    }

    @Test
    void testAll()  {
        assertAll(
                () -> assertEquals(1, 2),
                () -> assertEquals(1, 3)
        );
    }

    @Test
    void test()  {
        org.junit.jupiter.api.Assumptions.assumeTrue(1 == 2);
        assertEquals(1, 3);
    }

}
