package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorSumTest extends CalculatorBaseTest {

    @Test(dataProvider = "SumDataLong", dataProviderClass = CalculatorDataProviders.class)
    public void sumTestLong(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "SumDataDouble", dataProviderClass = CalculatorDataProviders.class)
    public void sumTestDouble(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
