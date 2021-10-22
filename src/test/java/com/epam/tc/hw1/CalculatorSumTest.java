package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest {

    @DataProvider(name = "TestData")
    public Object[][] sumDataProvider() {
        return new Object[][] {
            {1, 1, 2},
            {2, 2, 4},
            {3, 3, 6}
        };
    }

    @Test(dataProvider = "TestData")
    public void sumTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
