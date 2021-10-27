package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProviders {

    @DataProvider(name = "SumDataLong")
    static Object[][] sumDataProviderLong() {
        return new Object[][] {
            {1, 1, 2},
            {2, 2, 4},
            {3, 3, 6}
        };
    }

    @DataProvider(name = "SumDataDouble")
    static Object[][] sumDataProviderDouble() {
        return new Object[][] {
            {1, 1.1, 2.1},
            {2.2, 2.3, 4.5},
            {3, 3, 6}
        };
    }

    @DataProvider(name = "SubDataLong")
    static Object[][] subDataProviderLong() {
        return new Object[][] {
            {4, 2, 2},
            {5, 2, 3},
            {6, 2, 4}
        };
    }

    @DataProvider(name = "SubDataDouble")
    static Object[][] subDataProviderDouble() {
        return new Object[][] {
            {4.2, 2.1, 2.1},
            {5, 2.5, 2.5},
            {6, 2, 4}
        };
    }

    @DataProvider(name = "MultDataLong")
    static Object[][] multDataProviderLong() {
        return new Object[][] {
            {0, 0, 0},
            {0, 1, 0},
            {1, -2, -2},
            {-2, -2, 4},
            {100, 10, 1000}
        };
    }

    @DataProvider(name = "MultDataDouble")
    static Object[][] multDataProviderDouble() {
        return new Object[][] {
            {0, 1.1, 0},
            {2.1, 2, 4},
            {2.1, 3.1, 6},
            {10, 10, 100}
        };
    }

    @DataProvider(name = "DivDataLong")
    static Object[][] divDataProviderLong() {
        return new Object[][] {
            {4, 2, 2},
            {6, 2, 3},
            {8, 2, 4}
        };
    }

    @DataProvider(name = "DivDataDouble")
    static Object[][] divDataProviderDouble() {
        return new Object[][] {
            {4.4, 2, 2.2},
            {6.6, 3.1, 2.129},
            {0, 2.1, 0}
        };
    }
}
