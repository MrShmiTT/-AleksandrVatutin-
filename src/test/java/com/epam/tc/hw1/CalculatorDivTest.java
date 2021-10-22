package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest {

    @DataProvider(name = "TestData")
    public Object[][] divDataProvider() {
        return new Object[][] {
            {4, 2, 2},
            {6, 2, 3},
            {8, 2, 4}
        };
    }

    @Test(dataProvider = "TestData")
    public void subTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
