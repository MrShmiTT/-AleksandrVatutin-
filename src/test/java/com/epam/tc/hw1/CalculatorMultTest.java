package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CalculatorMultTest extends CalculatorBaseTest {

    @Test(dataProvider = "MultDataLong", dataProviderClass = CalculatorDataProviders.class)
    public void multTestLong(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "MultDataDouble", dataProviderClass = CalculatorDataProviders.class)
    public void multTestDouble(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected, Assertions.offset(0.1d));
    }
}
