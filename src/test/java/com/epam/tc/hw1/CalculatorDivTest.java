package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorDivTest extends CalculatorBaseTest {

    @Test(dataProvider = "DivDataLong", dataProviderClass = CalculatorDataProviders.class)
    public void divTestLong(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "DivDataDouble", dataProviderClass = CalculatorDataProviders.class)
    public void divTestDouble(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected, Assertions.offset(0.001d));
    }
}
