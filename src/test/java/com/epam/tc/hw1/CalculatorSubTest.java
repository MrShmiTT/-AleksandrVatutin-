package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest {

    @DataProvider(name = "TestData")
    public Object[][] sumDataProvider() {
        return new Object[][] {
            {4, 2, 2},
            {5, 2, 3},
            {6, 2, 4}
        };
    }

    @Test(dataProvider = "TestData")
    public void subTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
