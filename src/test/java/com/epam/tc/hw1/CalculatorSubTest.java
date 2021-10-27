package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CalculatorSubTest extends CalculatorBaseTest {

    @Test(dataProvider = "SubDataLong", dataProviderClass = CalculatorDataProviders.class)
    public void subTestLong(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "SubDataDouble", dataProviderClass = CalculatorDataProviders.class)
    public void subTestDouble(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
